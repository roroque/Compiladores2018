import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VM {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VM window = new VM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSelectfile = new JMenuItem("SelectFile");
		mntmSelectfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
		        int returnName = chooser.showOpenDialog(null);
		        String path;
		        if (returnName == JFileChooser.APPROVE_OPTION) {
		            File f = chooser.getSelectedFile();
		            if (f != null) { //garantia de que eh um arquivo e nao um diretorio escolhido
		 
		                path = f.getAbsolutePath(); //pega o caminho absoluto
		                System.out.println(path);
		                ReadTextFile(path);
		                
		                
		            }
		        }
			}
		});
		mntmSelectfile.setForeground(Color.LIGHT_GRAY);
		mnNewMenu.add(mntmSelectfile);
	}
	
	private void ReadTextFile(String FilePath) {
		
		
		
	}
}
