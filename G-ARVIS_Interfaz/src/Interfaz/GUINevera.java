package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GUINevera extends JPanel {

	private static final long serialVersionUID = 1L;

	GUINevera(){		
		this.setBorder(new TitledBorder(":::NEVERA:::"));
	
		JTextField introDato = new JTextField(20);
		JButton botonIntro = new JButton("Introducir");
		JTextArea listaProd = new JTextArea(5,23);
		listaProd.setSize(500, 300);
		JScrollPane scroll = new JScrollPane( listaProd );
		JButton botonSacar = new JButton("Sacar");		
		this.add(introDato);		
		this.add(botonIntro);
		this.add(scroll, BorderLayout.CENTER );
		this.add(botonSacar);		
	}
	
	
	
	
}
