/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete_principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import ejercicio_03_06.Figure;


/**
 *
 * @author Diego
 * 
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
    
    private JPanel configPanel;
    private JPanel dimensionPanel;
    private JPanel buttonsPanel;
    private JPanel formColorPanel;
    private PanelPrincipal drawPanel;
    private ArrayList<JLabel> labelList;
    private JTextField jTextFieldHeight;
    private JTextField jTextFieldWidth;
    private JComboBox jComboBoxFigure;
    private JComboBox jComboBoxColors;
    private JButton jButtonDraw;
    private JButton jButtonClear;
    

    public VentanaPrincipal(String title) {
        super(title);
        this.setSize(700, 700);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        initComponents();
        jButtonDraw.addActionListener(this);
        jButtonClear.addActionListener(this);
        
        
    }
    
    private void initComponents(){
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        configPanel = new JPanel();
//        
        formColorPanel = new JPanel();
        dimensionPanel = new JPanel();
        buttonsPanel = new JPanel();
        
        drawPanel = new PanelPrincipal(new Figure(0, Color.YELLOW, 0, 0));
//        
        drawPanel.setPreferredSize(new Dimension(300, 600));
        drawPanel.setBackground(Color.WHITE);
        
        getContentPane().add(configPanel);
        configPanel.add(formColorPanel);
        configPanel.add(dimensionPanel);
        configPanel.add(buttonsPanel);
        
        getContentPane().add(drawPanel);
        
        initLabels();
        initTextFields();
        initComboBox();
        initButtons();
        
        setPanels();
        
    }
    
    private void setPanels(){
       formColorPanel.add(labelList.get(0));
       formColorPanel.add(jComboBoxFigure);
       formColorPanel.add(labelList.get(1));
       formColorPanel.add(jComboBoxColors);
       
       dimensionPanel.add(labelList.get(2));
       dimensionPanel.add(labelList.get(3));
       dimensionPanel.add(jTextFieldHeight);
       dimensionPanel.add(labelList.get(4));
       dimensionPanel.add(jTextFieldWidth);
       
       buttonsPanel.add(jButtonDraw);
       buttonsPanel.add(jButtonClear);
        
    }
    
    private void initLabels(){
        labelList = new ArrayList<>();
       
        labelList.add(new JLabel("Figura"));
        labelList.add(new JLabel("Color"));
        labelList.add(new JLabel("Tamaño:"));
        labelList.add(new JLabel("Alto"));
        labelList.add(new JLabel("Ancho"));
        
        
    }
    
    private void initTextFields(){
        
        
        jTextFieldHeight = new JTextField(3);
        jTextFieldHeight.setText("100");
        jTextFieldWidth = new JTextField(3);
        jTextFieldWidth.setText("100");
    }
    
    private void initComboBox(){
        
        jComboBoxColors = new JComboBox();
        jComboBoxFigure = new JComboBox();
        
        jComboBoxFigure.addItem("Circulo");
        jComboBoxFigure.addItem("Estrella");
        jComboBoxFigure.addItem("Cuadrado");
        jComboBoxFigure.addItem("Rectangulo");
        jComboBoxFigure.addItem("Triangulo");
        
        jComboBoxColors.addItem("Amarillo");
        jComboBoxColors.addItem("Azul");
        jComboBoxColors.addItem("Rojo");
        jComboBoxColors.addItem("Verde");
//    
        
    }
    
    private void initButtons(){
        jButtonClear = new JButton("Eliminar");
        jButtonDraw = new JButton("Dibujar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jButtonDraw == e.getSource()) {
            getData();
            getColors();
            
        } else{
            drawPanel.getFigura().setHeight(0);
            drawPanel.getFigura().setWidth(0);
            drawPanel.repaint();
        }
      }
    
    private void getData(){ 
        drawPanel.getFigura().setFigura(jComboBoxFigure.getSelectedIndex());
        drawPanel.getFigura().setHeight(Integer.parseInt(jTextFieldHeight.getText()));
        drawPanel.getFigura().setWidth(Integer.parseInt(jTextFieldWidth.getText()));
              
    }
    private void getColors(){
        if (jComboBoxColors.getSelectedItem().equals("Amarillo")) {
            drawPanel.getFigura().setColor(Color.YELLOW);
        }
        if (jComboBoxColors.getSelectedItem().equals("Azul")) {
            drawPanel.getFigura().setColor(Color.BLUE);
        }
        if (jComboBoxColors.getSelectedItem().equals("Rojo")) {
            drawPanel.getFigura().setColor(Color.RED);
        }
          if (jComboBoxColors.getSelectedItem().equals("Verde")) {
            drawPanel.getFigura().setColor(Color.GREEN);
        }
//       
    }
    
    }
    
    
    

