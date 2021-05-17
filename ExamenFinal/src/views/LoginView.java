package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UsuarioDAO;
import models.Usuario;

public class LoginView {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(180, 33, 61, 16);
		frmLogin.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(180, 94, 130, 26);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setBounds(131, 99, 61, 16);
		frmLogin.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(104, 148, 61, 16);
		frmLogin.getContentPane().add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(180, 143, 130, 26);
		frmLogin.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!UsuarioDAO.login(new Usuario(textField.getText(), new String(passwordField.getPassword()))))
					JOptionPane.showMessageDialog(btnNewButton, "Error de inicio de sesión.");
				else {
					new WelcomeView();
					frmLogin.setVisible(false);
				}

			}
		});
		btnNewButton.setBounds(75, 199, 117, 29);
		frmLogin.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Registro");
		btnNewButton_1.setBounds(240, 199, 117, 29);
		frmLogin.getContentPane().add(btnNewButton_1);
		frmLogin.setVisible(true);
	}
}
