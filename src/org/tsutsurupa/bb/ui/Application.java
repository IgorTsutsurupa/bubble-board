package org.tsutsurupa.bb.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.tsutsurupa.bb.model.BubbleBoard;
import java.awt.BorderLayout;
import java.awt.Canvas;

public class Application {

	private JFrame frmBubbleBoard;

	private BubbleBoard board = new BubbleBoard();

	private final int BOARD_HEIGHT = board.getHeight() * 30;
	private final int BOARD_WIDTH = board.getWidth() * 30;

	private final int HEIGHT = BOARD_HEIGHT + 67;
	private final int WIDTH = BOARD_WIDTH + 6;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frmBubbleBoard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Application() {
		setSystemLookAndFeel();
		initialize();
	}

	private void initialize() {
		frmBubbleBoard = new JFrame();
		setProperties();

		JPanel settingsPanel = new JPanel();
		initPanel(settingsPanel);

		JCheckBox generatingBox = new JCheckBox("Generate bubbles");
		initGenerateBubblesCheckbox(generatingBox);
		settingsPanel.add(generatingBox);

		JButton playButton = new JButton("Play");
		initPlayButton(playButton);
		settingsPanel.add(playButton);

		JLabel scoreLabel = new JLabel("Score: 0");
		initScoreLabel(scoreLabel);
		settingsPanel.add(scoreLabel);

		JLabel helloPanel = new JLabel("bubbleboard");
		initHelloLabel(helloPanel);
		frmBubbleBoard.getContentPane().add(helloPanel);

		JPanel bubblePanel = new JPanel(); // Panel for bubbles
		bubblePanel.setBounds(0, 39, BOARD_WIDTH, BOARD_HEIGHT);
		frmBubbleBoard.getContentPane().add(bubblePanel);
	}

	private void setProperties() {
		frmBubbleBoard.setTitle("Bubble Board");
		frmBubbleBoard.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Application.class.getResource("/images/magicBubble.png")));
		frmBubbleBoard.setResizable(false);
		frmBubbleBoard.setBounds(100, 100, WIDTH, HEIGHT);
		frmBubbleBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBubbleBoard.getContentPane().setLayout(null);
	}

	private void initHelloLabel(JLabel label) {
		label.setBackground(new Color(153, 153, 255));
		label.setIcon(new ImageIcon(Application.class
				.getResource("/images/MainBackground.png")));
		label.setBounds(0, 39, BOARD_WIDTH, BOARD_HEIGHT);
	}

	private void initScoreLabel(JLabel label) {
		label.setBackground(new Color(153, 153, 255));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(145, 10, 188, 16);
	}

	private void initPlayButton(JButton button) {
		button.setBackground(new Color(153, 153, 255));
		button.setBounds(351, 7, 89, 23);
	}

	private void initGenerateBubblesCheckbox(JCheckBox checkbox) {
		checkbox.setBackground(new Color(153, 153, 255));
		checkbox.setBounds(6, 7, 125, 23);
	}

	private void initPanel(JPanel panel) {

		JPanel boardPanel = new JPanel();
		boardPanel.setBounds(0, 39, 450, 450);
		frmBubbleBoard.getContentPane().add(boardPanel);
		boardPanel.setLayout(new BorderLayout(0, 0));

		Canvas canvas = new Canvas();
		boardPanel.add(canvas, BorderLayout.CENTER);
		
		panel.setBackground(new Color(153, 153, 255));
		panel.setBounds(0, 0, 450, 40);
		frmBubbleBoard.getContentPane().add(panel);
		panel.setLayout(null);
	}

	private void setSystemLookAndFeel() {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
	}
}
