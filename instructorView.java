import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.Font;
import java.util.List;

public class instructorView extends JFrame implements ActionListener {

    private int screenNumber = 3;

    private int width = 1264;

    private int length = 700;

    private ImageIcon backImage;

    private ImageIcon leaderboardTitle;

    private JButton backButton;

    public instructorView(){

        setTitle("Ocean Odyssey");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(width,length);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel() {

            @Override

            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

// Draw the background image

                ImageIcon backgroundImage = new ImageIcon(getClass().getResource("Ocean background.jpg"));

                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);

            }

        };

        setContentPane(contentPane);

        contentPane.setLayout(null);

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

        Rectangle bounds = env.getMaximumWindowBounds();

        int width = bounds.width;

        int height = bounds.height;

        leaderboardTitle = new ImageIcon(getClass().getResource("students.png"));

        JLabel titleImage = new JLabel(leaderboardTitle);

        titleImage.setBounds((width - leaderboardTitle.getIconWidth()) / 2, 0, leaderboardTitle.getIconWidth(), leaderboardTitle.getIconHeight()); // Set bounds for the label

        contentPane.add(titleImage);

        backImage = new ImageIcon(getClass().getResource("bbutton.png"));

        backButton = new CustomButton(backImage);

        backButton.setPreferredSize(new Dimension(backImage.getIconWidth(), backImage.getIconHeight()));

        backButton.addActionListener(this);

        backButton.setContentAreaFilled(false);

        backButton.setBounds(10, 10, backImage.getIconWidth(), backImage.getIconHeight());

        contentPane.add(backButton);

        JPanel usernamePanel = new JPanel(new GridLayout(10, 1));

        usernamePanel.setOpaque(false);

        usernamePanel.setBounds(400, 250, 300, 400);

        contentPane.add(usernamePanel);

        Font font = new Font("Arial", Font.BOLD, 30);

        JPanel scorePanel = new JPanel(new GridLayout(10, 1));

        scorePanel.setOpaque(false);

        scorePanel.setBounds(700, 250, 300, 400);

        contentPane.add(scorePanel);

        JPanel levelPanel = new JPanel(new GridLayout(10, 1));

        levelPanel.setOpaque(false);

        levelPanel.setBounds(1000, 250, 300, 400);

        contentPane.add(levelPanel);

        List<User> users = Save.getUsers();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals("instructor")) {
                continue;
            }

            JLabel userNameLabel = new JLabel("User:  " + users.get(i).getUsername());

            JLabel scoreLabel = new JLabel("Score:  " + users.get(i).getHighScore());

            JLabel levelLabel = new JLabel ("Levels:  " + users.get(i).getMaxLevel());

            userNameLabel.setFont(font);

            usernamePanel.add(userNameLabel);

            scoreLabel.setFont(font);

            scorePanel.add(scoreLabel);

            levelLabel.setFont(font);

            levelPanel.add(levelLabel);

        }

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {

            if (screenNumber== 3) {

                screenNumber= 0;

                setVisible(false);

                this.dispose();

                menu menuScreen = new menu();

            }

        }

    }
}