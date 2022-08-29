package personas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 
public class JFrameVentanaPrincipal extends javax.swing.JFrame implements ActionListener {
	private ClsListaPersonas lista; // El objeto ListaPersonas de la aplicación
	private Container contenedor; /* Un contenedor de elementos gráficos */
	// Etiquetas estáticas para los nombres de los atributos
	private JLabel nombre, apellidos, teléfono, dirección;
	// Campos de ingreso de texto
	private JTextField campoNombre, campoApellidos, campoTeléfono,campoDirección;
	private JButton guardar, eliminar, borrarLista; // Botones
	private JList listaNombres; // Lista de personas
	private DefaultListModel modelo; // Objeto que modela la lista
	private JScrollPane scrollLista; // Barra de desplazamiento vertical

/**
* Constructor de la clase VentanaPrincipal
*/
	public JFrameVentanaPrincipal(){
		lista = new ClsListaPersonas(); // Crea la lista de personas
		inicio();
		setTitle("Personas"); // Establece el título de la ventana
		setSize(400,400); // Establece el tamaño de la ventana
		setLocationRelativeTo(null); /* La ventana se posiciona en el centro de la pantalla */
		// Establece que el botón de cerrar permitirá salir de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); /* Establece que el tamaño de la ventana no se puede cambiar */
	}
/**
* Método que crea la ventana con sus diferentes componentes
* gráficos
*/
	private void inicio() {
		contenedor = getContentPane(); /* Obtiene el panel de contenidos de la ventana */
		contenedor.setLayout(null); /* Establece que el panel no tiene asociado ningún layout */
		
                // Establece la etiqueta y el campo nombre
		nombre = new JLabel();
		nombre.setText("Nombre:");
		nombre.setBounds(20, 20, 255, 23); /* Establece la posición de la etiqueta nombre */
		campoNombre = new JTextField();
		// Establece la posición del campo de texto nombre
		campoNombre.setBounds(105, 20, 255, 23);
		
                // Establece la etiqueta y el campo apellidos
		apellidos = new JLabel();
                apellidos.setText("Apellidos:");/* Establece la posición de la etiqueta apellidos */
                apellidos.setBounds(20, 50, 255, 23);
		campoApellidos = new JTextField();
		// Establece la posición del campo de texto apellidos
		campoApellidos.setBounds(105, 50, 255, 23);
		
                // Establece la etiqueta y el campo teléfono
		teléfono = new JLabel();
		teléfono.setText("Teléfono:");
		teléfono.setBounds(20, 80, 255, 23); /* Establece la posición de la etiqueta teléfono */
		campoTeléfono = new JTextField();
		// Establece la posición del campo de texto teléfono
		campoTeléfono.setBounds(105, 80, 255, 23);
		
                // Establece la etiqueta y el campo dirección
		dirección = new JLabel();
		dirección.setText("Dirección");
		dirección.setBounds(20, 110, 255, 23); /* Establece la posición de la etiqueta dirección */
		campoDirección = new JTextField();
		// Establece la posición del campo de texto dirección
		campoDirección.setBounds(105, 110, 255, 23);
		
                // Establece el botón Añadir persona
		guardar = new JButton();
		guardar.setText("Guardar");
		guardar.setBounds(105, 150, 80, 23); /* Establece la posición del botón Añadir persona */
		/* Agrega al botón un ActionListener para que gestione eventos del botón */
		guardar.addActionListener((ActionListener) (this));
		
                // Establece el botón Eliminar persona
		eliminar= new JButton();
		eliminar.setText("Eliminar");
		eliminar.setBounds(20, 280, 80, 23); /* Establece la posición del botón Eliminar persona */
		/* Agrega al botón un ActionListener para que gestione eventos del botón */
		eliminar.addActionListener((ActionListener) (this));
		
                // Establece el botón Borrar lista
		borrarLista= new JButton();
		borrarLista.setText("Borrar Lista");
		borrarLista.setBounds(120, 280, 120, 23); /* Establece la posición del botón Borrar lista */
		/* Agrega al botón un ActionListener para que gestione eventos del botón */
		borrarLista.addActionListener((ActionListener) (this));

		// Establece la lista gráfica de personas
		listaNombres = new JList();
                /* Establece que se pueda seleccionar solamente un elemento de la lista */
		listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultListModel();
               
		// Establece una barra de desplazamiento vertical
		scrollLista = new JScrollPane();
		// Establece la posición de la barra de desplazamiento vertical
		scrollLista.setBounds(20, 190 ,255, 80);
		// Asocia la barra de desplazamiento vertical a la lista de personas
		scrollLista.setViewportView(listaNombres);
		// Se añade cada componente gráfico al contenedor de la ventana
		contenedor.add(nombre);
		contenedor.add(campoNombre);
		contenedor.add(apellidos);
		contenedor.add(campoApellidos);
		contenedor.add(teléfono);
		contenedor.add(campoTeléfono);
		contenedor.add(dirección);
		contenedor.add(campoDirección);
		contenedor.add(guardar);
		contenedor.add(eliminar);
		contenedor.add(borrarLista);
		contenedor.add(scrollLista);
	}
/**
* Método que gestiona los eventos generados en la ventana principal
     * @param evento
*/

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == guardar) { // Si se pulsa el botón añadir
			añadirPersonas(); // Se invoca añadir persona
		}
		if (evento.getSource() == eliminar) { /* Si se pulsa el botón eliminar */
		/* Se invoca el método eliminarNombre que elimina el elemento seleccionado */
			eliminarPeronas(listaNombres.getSelectedIndex() );
		}

		if (evento.getSource() == borrarLista) { /* Si se pulsa el botón borrar lista */
			borraLista(); // Se invoca borrar lista
		}
	}
/**
* Método que agrega una persona al vector de personas y a la lista
* gráfica de personas
*/
	private void añadirPersonas() {
/* Se obtienen los campos de texto ingresados y se crea una persona */
	ClsPeronsa p;
            p = new ClsPeronsa(campoNombre.getText(), campoApellidos.getText(), campoTeléfono.getText(), campoDirección.getText());
	lista.añadirPersonas(p); /* Se añade una persona al vector de personas */
	String elemento = campoNombre.getText() + "-" +	campoApellidos.getText() + "-" + campoTeléfono.getText() + "-" + campoDirección.getText();
	modelo.addElement(elemento); /* Se agrega el texto con losdatos de la persona al JList */
	listaNombres.setModel(modelo);
// Se colocan todos los campos de texto nulos
	campoNombre.setText("");
	campoApellidos.setText("");
	campoTeléfono.setText("");
	campoDirección.setText("");
	}
/**
* Método que elimina una persona del vector de personas y de la
* lista gráfica de personas en la ventana
* @param indice Parámetro que define la posición de la persona a
* eliminar
*/
	private void eliminarPeronas(int indice) {
		if (indice >= 0) { // Si la posición existe modelo.removeElementAt(indice); /* Se elimina la persona seleccionada de la lista gráfica */
                    modelo.removeElementAt(indice);
                    lista.eliminarPeronas(indice); /* Se elimina la persona seleccionada del vector de personas */
		} else { /* Si no se seleccionó ninguna persona, se genera un mensaje de error */
			JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
/**
* Método que elimina todas las personas del vector de personas
*/
	private void borraLista() {
		lista.borraLista(); // Se eliminan todas las personas del vector
		modelo.clear(); // Limpia el JList, la lista gráfica de personas
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrameVentanaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
