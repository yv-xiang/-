set -e

log() {
    current_datetime=$(date +"%Y-%m-%d %H:%M:%S")
    echo "[${current_datetime}] $1"
}

log "starting venv prepare"
sha1_value=$(sha1sum Pipfile.lock | cut -d ' ' -f 1)
hdfs_path="oss://bigdata-ryx/scripts/python-venv/${sha1_value}.tgz"
if hadoop fs -test -e "$hdfs_path"; then
    log "fetching venv image from oss"
    hadoop fs -get "$hdfs_path" .
    log "extracting..."
    tar -xzf "${sha1_value}.tgz"
else
    log "running pipenv install"
    sed -i 's/^url\s*=.*/url = "https:\/\/pypi.tuna.tsinghua.edu.cn\/simple\/"/' Pipfile
    pipenv install
    log "uploading venv image"
    tar -czf "${sha1_value}.tgz" .venv
    hadoop fs -put "${sha1_value}.tgz" "$hdfs_path"
fi
log "venv is ready."
