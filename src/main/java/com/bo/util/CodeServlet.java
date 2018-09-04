package com.bo.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
         * 注意:下载图片 文档  音频  视频
         * 请使用字节流进行下载功能的实现
         * */

        //验证码
        /*
         * 1:构建一个图片缓冲区(缓存区域)大小-->图片的大小
         * 2:画笔
         * 3:写内容(先去设置颜色,Color,Font)
         * 4:画干扰线
         * 5:将图片写出去(浏览器)
         * */
        //构建了一个空白图片(纸)
        BufferedImage image = new BufferedImage(120, 30, BufferedImage.TYPE_INT_RGB);
        //绘图工具
        Graphics g = image.createGraphics();
        //设置图片缓冲区的背景颜色
        g.setColor(Color.GRAY);
        //将背景颜色填充
        g.fillRect(0, 0, 120, 30);
        //设置边框
        g.setColor(Color.BLACK);
        g.clipRect(0, 0, 120 - 2, 30 - 2);
        //设置填充的内容
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        g.setColor(Color.RED);
        g.setFont(new Font("隶书", Font.BOLD, 20));
        String newtext = createRandomChar((Graphics2D) g, text);
        //生成的验证码存放到我们的会话域中
        req.getSession().setAttribute("code", newtext);
        g.setColor(Color.GREEN);
        //画干扰线
        for (int i = 0; i < 5; i++) {
            int x1 = new Random().nextInt(120);
            int y1 = new Random().nextInt(30);
            int x2 = new Random().nextInt(120);
            int y2 = new Random().nextInt(30);
            g.drawLine(x1, y1, x2, y2);
        }
        //响应头设置
        resp.setContentType("image/jpeg");
        //将图片写出到浏览器
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    private String createRandomChar(Graphics2D g, String baseChar) {
        StringBuffer sb = new StringBuffer();
        int x = 5;
        String ch = "";
        // 控制字数
        for (int i = 0; i < 4; i++) {
            // 设置字体旋转角度
            int degree = new Random().nextInt() % 30;
            ch = baseChar.charAt(new Random().nextInt(baseChar.length())) + "";
            sb.append(ch);
            // 正向角度
            g.rotate(degree * Math.PI / 180, x, 20);
            g.drawString(ch, x, 20);
            // 反向角度
            g.rotate(-degree * Math.PI / 180, x, 20);
            x += 30;
        }
        return sb.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
