import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.border.EmptyBorder;

public class Toolbox {
    public static void main(String args[]) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel btnPanel = new JPanel(new GridLayout(12, 1));

        // R studio button
        JButton rstudioButton = new JButton("R Studio");

        rstudioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("http://host.docker.internal:8787");                
            }
        });

        btnPanel.add(rstudioButton);

        // Spyder button
        JButton spyderButton = new JButton("Spyder");

        spyderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Runtime rt = Runtime.getRuntime();
                    Process pr = rt.exec("spyder3");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });

        btnPanel.add(spyderButton);

        // IBM SAS button
        JButton ibmsasButton = new JButton("IBM SAS");

        ibmsasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("https://welcome.oda.sas.com/login");
            }
        });

        btnPanel.add(ibmsasButton);

        // Wetty git button
        JButton gitButton = new JButton("Git");

        gitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //openURL("http://host.docker.internal:3000");

                try {
                    Runtime rt = Runtime.getRuntime();
                    Process pr = rt.exec("xterm");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }  
            }
        });

        btnPanel.add(gitButton);

        // Jupyter button
        JButton jupyterButton = new JButton("Jupyter");

        jupyterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("http://host.docker.internal:8888?token=easy");
            }
        });

        btnPanel.add(jupyterButton);

        // Orange button
        JButton orangeButton = new JButton("Orange");

        orangeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("http://host.docker.internal:6901");
            }
        });

        btnPanel.add(orangeButton);

        // VS code button
        JButton vsCodeButton = new JButton("VS Code");

        vsCodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("http://host.docker.internal:8443");
            }
        });

        btnPanel.add(vsCodeButton);

        // Pyspark button
        JButton pysparkButton = new JButton("PySpark");

        pysparkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("http://host.docker.internal:8999?token=easy");
            }
        });

        btnPanel.add(pysparkButton);

        // Tableau button
        JButton tableauButton = new JButton("Tableau");

        tableauButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("https://sso.online.tableau.com/public/idp/SSO");
            }
        });

        btnPanel.add(tableauButton);

        // Sonar Cloud button
        JButton sonarCloudButton = new JButton("SonarCloud");

        sonarCloudButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("https://sonarcloud.io/sessions/new");
            }
        });

        btnPanel.add(sonarCloudButton);

        // Tensorflow button
        JButton tensorflowButton = new JButton("Tensorflow");

        tensorflowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("http://host.docker.internal:8989?token=easy");
            }
        });

        btnPanel.add(tensorflowButton);

        // Markdown button
        JButton markdownButton = new JButton("Markdown");

        markdownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openURL("http://host.docker.internal:4000");
            }
        });

        btnPanel.add(markdownButton);


        layout.add(btnPanel);
        panel.add(layout, BorderLayout.CENTER);
        JFrame frame = new JFrame("Data Science Toolbox");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public static void openURL(String url)
    {
        Runtime rt = Runtime.getRuntime();
        // String[] browsers = { "firefox", "mozilla", "konqueror", "netscape", "opera", "links", "lynx" };

        StringBuffer cmd = new StringBuffer();
        cmd.append(String.format("%s \"%s\"", "firefox", url));
        // for (int i = 0; i < browsers.length; i++)
        //     if (i == 0)
        //         cmd.append(String.format("%s \"%s\"", browsers[i], url));
        //     else
        //         cmd.append(String.format(" || %s \"%s\"", browsers[i], url));
        // If the first didn't work, try the next browser and so on

        try {
            rt.exec(new String[] { "sh", "-c", cmd.toString() });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}
