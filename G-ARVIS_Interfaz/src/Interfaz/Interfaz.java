package Interfaz;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.Element;

public class Interfaz extends JFrame {
	
	JTextArea areaCodigo =new JTextArea("");	
	JLabel lineaColumnaAreaCodigo = new JLabel("Posici�n del puntero :  (0,0)");
//	JLabel labelToken = new JLabel("G-ARVIS, EL SISTEMA INTELIGENTE PARA TU CASA");	
	JTextArea areaIn = new JTextArea("Aqu� se escriben las entradas",2,5);	
	private static final long serialVersionUID = 1L;

	public Interfaz() {
		inicializarInterfaz();  
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});

	}

	public void inicializarInterfaz() {
		//this.setJMenuBar(getMenuPrincipal());
		this.setContentPane(getPanelPrincipal());
		this.setTitle("PROYECTO DE DASI, Grupo G");
	}
	
	private JPanel getPanelPrincipal() {
		JPanel panelPrincipal = new JPanel();
		BorderLayout b = new BorderLayout();
		panelPrincipal.setLayout(b);
		
			JPanel panelSuperior = new JPanel(new GridLayout(1,3));			
			panelSuperior.add(construyeAreaLenguajeP());
//			panelPrincipal.add("North",labelToken);
			panelPrincipal.add("Center",panelSuperior);
	
//		panelPrincipal.add("South",construyeAreaInferior());
		return panelPrincipal;
	}
	
	
	public JPanel construyeAreaLenguajeP(){
		
		JPanel panelRecursos = new JPanel();
		panelRecursos.setLayout(new GridLayout(2,4)); 
		GUINevera nevera = new GUINevera();
		GUIMicroondas microondas = new GUIMicroondas();
		GUITele tele = new GUITele();
		GUIBiblio biblio = new GUIBiblio();
		GUIChampu champu = new GUIChampu();
		
		panelRecursos.add(nevera);
		panelRecursos.add(microondas); 
		panelRecursos.add(tele);
		panelRecursos.add(biblio);
		panelRecursos.add(champu);
		
		
		
		for (int i = 0; i < 3; i++){
			panelRecursos.add(new JButton("Button " + i));
		}
		
		return panelRecursos;
		
	}
	
	
//	public JPanel construyeAreaInferior(){
//		JPanel areaInferior = new JPanel();		
//		BorderLayout bl = new BorderLayout();
//		areaInferior.setLayout(bl);		
//		
//		JPanel panelBotones = new JPanel();
//		//panelBotones.setSize(5, 5);
//		
//		
//		final JButton enviarButton = new JButton("Enviar");			
//			panelBotones.add(enviarButton);						
//		areaInferior.add("Center", construyeAreaIn());
//		areaInferior.add("East", construyeBoton());
//		
//		return  areaInferior;
//	}

	
	
	public void oyenteEjecutar(final JButton ejecutarButton){
		ejecutarButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			if(ejecutarButton==e.getSource()){			
				
				System.out.print("Hola");
				//sintactico.comenzarAnalisisSintactico();
				
					//buscarEntradas();	
							
			}
			
		}});
	}
	
	
	public JPanel construyeAreaIn(){
		JPanel outPPanel = new JPanel();
		//outPPanel.setBorder(new TitledBorder("Entrada:"));
		
		BorderLayout bl = new BorderLayout();
		outPPanel.setBorder(new TitledBorder("Entrada:"));
		outPPanel.setLayout(bl);		
	
		
		areaIn.setFont(new Font("Calibri", Font.PLAIN, 15));
		JScrollPane scroll = new JScrollPane( areaIn );
				
		outPPanel.add("Center", scroll);
		
		return outPPanel;
		
	}	
//
//	public JPanel construyeBoton(){
//		
//		JPanel outPPanel = new JPanel();
//		outPPanel.setBorder(new TitledBorder(" "));
//		
//		BorderLayout bl = new BorderLayout();
//		outPPanel.setLayout(bl);		
//	
//		
//		JButton btnEnviar = new JButton("ENVIAR");
//		
//		outPPanel.add("Center", btnEnviar);
//		
//		return outPPanel;
//	}	

		
//	void leerLineasTextArea(){
//		String text = areaCodigo.getText() ;
//		StringTokenizer st = new StringTokenizer(text,"\n") ;
//		while (st.hasMoreTokens()) {
//		     String linea = st.nextToken();		
//		     String palabra[] = linea.split(" ");
//		     
//		     for(int i=0; i<palabra.length;i++){
//		    	 labelToken.setText("Token: "+palabra[i]);
//		    	 
//		     }
//		}
//	}
	
		
	JMenuItem getSalirItem() {
		JMenuItem salirItem = new JMenuItem();
		salirItem.setText("Salir");
		salirItem.setMnemonic('S');
		salirItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.CTRL_MASK));		

		salirItem.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){								
			if(JOptionPane.showConfirmDialog(JOptionPane.getFrameForComponent(getParent()),
					"�Est� seguro que quiere cerrar?","Mensaje",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){					 
				System.exit(1);
				}
			}});	

		return salirItem;		
	}

	
	// Clase para el contador linea/columna
	class CaretList implements CaretListener {
        
        public CaretList(JTextArea textoEntrada)
        {
        	areaCodigo = textoEntrada;
        }
       
        public void caretUpdate(CaretEvent arg0) {
            int caretPosition = areaCodigo.getCaretPosition();
            Element root = areaCodigo.getDocument().getDefaultRootElement();//areaCodigo.getDocument().getDefaultRootElement();
            
            int linea = root.getElementIndex(caretPosition);      
            int lineStart = root.getElement(linea).getStartOffset();
            int columna = (caretPosition - lineStart);            
            lineaColumnaAreaCodigo.setText("Posici�n del puntero :  ("+Integer.toString(linea)+","+String.valueOf(columna)+")");       
           
        }       
    }
	
	
	
	
	public static void main(String[] args) {
		
		Interfaz interfaz = new Interfaz();
		
		interfaz.setVisible(true);
		interfaz.setEnabled(true);
		interfaz.setSize(1000, 600);
		interfaz.setResizable(false);
		//interfaz.setExtendedState(JFrame.MAXIMIZED_BOTH);
	
		
	}

}
