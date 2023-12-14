package com.system_gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ShoppingCenterFrame extends JFrame {
    private JLabel userName;
    private JLabel password;
    private JTextField userNameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public ShoppingCenterFrame() {
        Container container = getContentPane();
        JPanel mainPanel = new JPanel(new GridLayout());
        JPanel topPanel = new JPanel(new GridLayout());
        JPanel centerPanel = new JPanel(new FlowLayout());
    }
}
