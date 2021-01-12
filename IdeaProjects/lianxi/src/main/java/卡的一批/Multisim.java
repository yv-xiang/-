package 卡的一批;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Multisim extends JFrame {
    // 定义组件
    private static final long serialVersionUID = 1L;
    JPanel jp1, jp2;
    JButton jb1, jb2, jb3, jb4, jb5, jb6;

    public static void main(String[] args) {
        new Multisim();
}




    public Multisim() {
        // 创建组件
        // JPanel布局默认是FlowLayout流布局
        jp1 = new JPanel();
        jp2 = new JPanel();

        jb1 = new JButton("西瓜");
        jb2 = new JButton("苹果");
        jb3 = new JButton("荔枝");
        jb4 = new JButton("葡萄");
        jb5 = new JButton("桔子");
        jb6 = new JButton("香蕉");

        // 设置布局管理器(Jpanel默认流布局)
        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(jb5);

        // 把Panel加入JFrame
        this.add(jp1, BorderLayout.NORTH);
        this.add(jb6, BorderLayout.CENTER);
        this.add(jp2, BorderLayout.SOUTH);

        // 设置窗体
        // 窗体大小
        this.setSize(300, 250);
        // 屏幕显示初始位置
        this.setLocation(200, 200);
        // 显示
        this.setVisible(true);
        // 退出窗体后将JFrame同时关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}