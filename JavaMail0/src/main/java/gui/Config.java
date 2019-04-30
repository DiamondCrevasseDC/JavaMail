package gui;

import mail.SendHtmlMail;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;

public class Config {
    private JTabbedPane tabbedPane1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton 选择目录;
    private JPanel panel0;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel7;
    private JPanel JPanel1;
    private JTextField textField3;
    private JTextField textField1;
    private JButton 选择文件;
    private JButton comfirm;
    private JPanel 按钮;
    private JPanel mailJpanel;
    private JTextField from;
    private JPanel bJpanel;
    private JTextField smtp;
    private JTextField user;
    private JTextField password;
    private JPanel send;
    private JFileChooser jfc;
    private JFileChooser xmlJfc;
    private MailThread mailThread;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Config config = new Config();

            JFrame frame = new JFrame("Config");

            // 文件选择器的初始目录定为D盘
            config.jfc.setCurrentDirectory(new File("D:\\report"));

            frame.setContentPane(config.panel0);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;
            frame.setSize(700, 500);
            frame.setLocation(screenWidth / 4, screenHeight / 4);
        });
    }

    public Config() {

        jfc = new JFileChooser();
        xmlJfc = new JFileChooser();
        xmlJfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                String name = f.getName();
                return name.toLowerCase().endsWith(".xml");
            }

            @Override
            public String getDescription() {
                return "*.xml";
            }
        });

        选择目录.addActionListener(e -> {

            // 设定只能选择到文件夹
            jfc.setFileSelectionMode(1);
            // 此句是打开文件选择器界面的触发语句
            int state = jfc.showOpenDialog(null);
            if (state == 1) {
                return;
            } else {
                File f = jfc.getSelectedFile();// f为选择到的目录
                textField1.setText(f.getAbsolutePath());
            }
        });

        选择文件.addActionListener(e -> {
            // 设定只能选择到文件
            xmlJfc.setFileSelectionMode(0);
            // 此句是打开文件选择器界面的触发语句
            int state = xmlJfc.showOpenDialog(null);
            if (state == 1) {
                // 撤销则返回
                return;
            } else {
                File f = xmlJfc.getSelectedFile();// f为选择到的文件
                textField2.setText(f.getAbsolutePath());
            }
        });
        comfirm.addActionListener(e -> {
//            MailThread mailThread = new MailThread();
//            mailThread.start();
            SendHtmlMail sendHtmlMail = new SendHtmlMail(this);
            sendHtmlMail.start();
        });
//        结束.addActionListener(e -> {
            /**
             * interrupt()的作用是中断本线程。
             * 本线程中断自己是被允许的；其它线程调用本线程的interrupt()方法时，会通过checkAccess()检查权限。这有可能抛出SecurityException异常。
             * 如果本线程是处于阻塞状态：调用线程的wait(), wait(long)或wait(long, int)会让它进入等待(阻塞)状态，或者调用线程的join(), join(long), join(long, int), sleep(long), sleep(long, int)也会让它进入阻塞状态。若线程在阻塞状态时，调用了它的interrupt()方法，那么它的“中断状态”会被清除并且会收到一个InterruptedException异常。例如，线程通过wait()进入阻塞状态，此时通过interrupt()中断该线程；调用interrupt()会立即将线程的中断标记设为“true”，但是由于线程处于阻塞状态，所以该“中断标记”会立即被清除为“false”，同时，会产生一个InterruptedException的异常。
             * 如果线程被阻塞在一个Selector选择器中，那么通过interrupt()中断它时；线程的中断标记会被设置为true，并且它会立即从选择操作中返回。
             * 如果不属于前面所说的情况，那么通过interrupt()中断线程时，它的中断标记会被设置为“true”。
             * 中断一个“已终止的线程”不会产生任何操作。
             */
//            mailThread.interrupt();
//        });
    }

    class MailThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE; i ++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException execption) {
                    execption.printStackTrace();
                }
                textArea1.append("------" + i + "------" + "\n");
                textArea1.append("------world------" + "\n");
                textArea1.setCaretPosition(textArea1.getDocument().getLength());
            }
        }
    }

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    public void setTabbedPane1(JTabbedPane tabbedPane1) {
        this.tabbedPane1 = tabbedPane1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JButton get选择目录() {
        return 选择目录;
    }

    public void set选择目录(JButton 选择目录) {
        this.选择目录 = 选择目录;
    }

    public JPanel getPanel0() {
        return panel0;
    }

    public void setPanel0(JPanel panel0) {
        this.panel0 = panel0;
    }

    public JPanel getJPanel2() {
        return JPanel2;
    }

    public void setJPanel2(JPanel JPanel2) {
        this.JPanel2 = JPanel2;
    }

    public JPanel getJPanel3() {
        return JPanel3;
    }

    public void setJPanel3(JPanel JPanel3) {
        this.JPanel3 = JPanel3;
    }

    public JPanel getJPanel7() {
        return JPanel7;
    }

    public void setJPanel7(JPanel JPanel7) {
        this.JPanel7 = JPanel7;
    }

    public JPanel getJPanel1() {
        return JPanel1;
    }

    public void setJPanel1(JPanel JPanel1) {
        this.JPanel1 = JPanel1;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JButton get选择文件() {
        return 选择文件;
    }

    public void set选择文件(JButton 选择文件) {
        this.选择文件 = 选择文件;
    }

    public JButton getComfirm() {
        return comfirm;
    }

    public void setComfirm(JButton comfirm) {
        this.comfirm = comfirm;
    }

    public JPanel get按钮() {
        return 按钮;
    }

    public void set按钮(JPanel 按钮) {
        this.按钮 = 按钮;
    }

    public JPanel getMailJpanel() {
        return mailJpanel;
    }

    public void setMailJpanel(JPanel mailJpanel) {
        this.mailJpanel = mailJpanel;
    }

    public JTextField getFrom() {
        return from;
    }

    public void setFrom(JTextField from) {
        this.from = from;
    }

    public JPanel getbJpanel() {
        return bJpanel;
    }

    public void setbJpanel(JPanel bJpanel) {
        this.bJpanel = bJpanel;
    }

    public JTextField getSmtp() {
        return smtp;
    }

    public void setSmtp(JTextField smtp) {
        this.smtp = smtp;
    }

    public JTextField getUser() {
        return user;
    }

    public void setUser(JTextField user) {
        this.user = user;
    }

    public JTextField getPassword() {
        return password;
    }

    public void setPassword(JTextField password) {
        this.password = password;
    }
}
