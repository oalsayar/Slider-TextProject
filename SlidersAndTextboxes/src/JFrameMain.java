import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldV;
	private JTextField textField_H;
	JSlider sliderH;

	/**
	 * Launch the application.
	 * Demenstrate use of sliders interacting with 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider sliderH = new JSlider();
		sliderH.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				// update the text field H
				JSlider me = (JSlider)arg0.getSource();
				textField_H.setText("" +me.getValue());
			}
		});
		sliderH.setMajorTickSpacing(10);
		sliderH.setMinorTickSpacing(5);
		sliderH.setPaintTicks(true);
		sliderH.setPaintLabels(true);
		sliderH.setBounds(106, 11, 522, 82);
		contentPane.add(sliderH);
		
		JSlider slider_1V = new JSlider();
		slider_1V.setPaintTicks(true);
		slider_1V.setPaintLabels(true);
		slider_1V.setMinorTickSpacing(2);
		slider_1V.setMajorTickSpacing(20);
		slider_1V.setOrientation(SwingConstants.VERTICAL);
		slider_1V.setBounds(0, 125, 115, 296);
		contentPane.add(slider_1V);
		
		textFieldV = new JTextField();
		textFieldV.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldV.setText("50");
		textFieldV.setBounds(156, 390, 86, 20);
		contentPane.add(textFieldV);
		textFieldV.setColumns(10);
		
		textField_H = new JTextField();
		textField_H.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JTextField me = (JTextField)arg0.getSource();
				sliderH.setValue(Integer.parseInt(me.getText()));
			}
		});
		textField_H.setText("50");
		textField_H.setHorizontalAlignment(SwingConstants.CENTER);
		textField_H.setColumns(10);
		textField_H.setBounds(541, 104, 86, 20);
		contentPane.add(textField_H);
	}
}
