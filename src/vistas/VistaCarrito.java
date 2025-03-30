/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import modelos.Movie;
import persistencia.Serializadora;

import javax.imageio.ImageIO;
import javax.swing.*;

import controladores.FrontEnd.ControladorVistaCarrito;
import controladores.FrontEnd.ControladorVistaUsuario;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author JuanCGallo
 */
public class VistaCarrito extends javax.swing.JFrame {

	/**
	 * Creates new form VistaCarrito
	 */
	private ControladorVistaCarrito controladorVistaCarrito;
	private ControladorVistaUsuario controladorVistaUsuario;
	JButton[][] pelis;
	JLabel[][] titulos;
	JLabel[][] puntuaciones;
	int filas;

	public VistaCarrito() {
		initComponents();
		setLocationRelativeTo(this);
		controladorVistaCarrito = new ControladorVistaCarrito();
		controladorVistaUsuario = new ControladorVistaUsuario();
		filas = controladorVistaCarrito.getFilas();
		pelis = new JButton[filas][];
		titulos = new JLabel[filas][];
		puntuaciones = new JLabel[filas][];
		dibujarCarrito();
	}

	private void dibujarCarrito() {

		int separadoX = 20;
		int separadoY = 30;
		int ancho = 120;
		int alto = (int) (((double) ancho) * 1.6);
		int margen = 20;
		ArrayList<Movie> carrito = controladorVistaCarrito.getCarrito();
		int peliculasPorFila = controladorVistaUsuario.getPELICULAS_POR_FILA();
		int cantidadPeliculas = carrito.size();

		for (int i = 0; i < pelis.length; i++) {
			 int len = (i == pelis.length-1) ? (cantidadPeliculas - (filas-1) * peliculasPorFila) : peliculasPorFila;
			 System.out.println("pelis.length:" + pelis.length + " len:" + len);
			 pelis[i] = new JButton[len];
			 titulos[i] = new JLabel[len];
			 puntuaciones[i] = new JLabel[len];
			 for (int j = 0; j < len; j++) {
				  pelis[i][j] = new JButton();
				  titulos[i][j] = new JLabel();
				  puntuaciones[i][j] = new JLabel();
				  // setbounds (posX, posY, ancho, alto)
				  pelis[i][j].setBounds(
						   (ancho + margen) * j + separadoX,
						   (alto + margen) * i + separadoY,
						   ancho, alto
				  );
				  int ALTO_TITULO = 15;
				  double RATIO_ANCHO = 0.8;
				  titulos[i][j].setBounds(
						   (ancho + margen) * j + separadoX,
						   (alto + margen) * i + separadoY + alto * (i + 1),
						   (int) ((double) ancho * (RATIO_ANCHO)),
						   ALTO_TITULO
				  );
//				titulos[i][j].setOpaque(true);
				  titulos[i][j].setText(carrito.get(i+j).getTitulo());
				  titulos[i][j].setBackground(Color.RED);
				  titulos[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				  titulos[i][j].setVerticalAlignment(SwingConstants.CENTER);
				  puntuaciones[i][j].setBounds(
						   (ancho + margen) * j + separadoX + (int) ((double) ancho * RATIO_ANCHO),
						   (alto + margen) * i + separadoY + alto * (i + 1),
						   (int) ((double) ancho * (1 - RATIO_ANCHO)),
						   ALTO_TITULO
				  );
//				puntuaciones[i][j].setOpaque(true);
				  puntuaciones[i][j].setText(String.valueOf(carrito.get(i+j).getPuntuacion()));
				  puntuaciones[i][j].setBackground(Color.BLUE);
				  puntuaciones[i][j].setForeground(Color.WHITE);
				  puntuaciones[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				  puntuaciones[i][j].setVerticalAlignment(SwingConstants.CENTER);
				  try {
					  //TODO: cambiar ruta de acceso
					  Image img = ImageIO.read(getClass().getResource("/img/terminator_2.jpg"));
					  img = img.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
					  pelis[i][j].setIcon(new ImageIcon(img));
				  } catch (Exception ex) {
					  System.out.println(ex);
				  }
				  panelPeliculas.add(pelis[i][j]);
				  panelPeliculas.add(titulos[i][j]);
				  panelPeliculas.add(puntuaciones[i][j]);
			 }
		}

		int anchoPanel = peliculasPorFila * (ancho + margen) + 2 * separadoX;
		int altoPanel = filas * (alto + margen) + 2 * separadoY;
		panelPeliculas.setPreferredSize(new Dimension(anchoPanel, altoPanel));
		panelPeliculas.revalidate();
		jScrollPane1.getVerticalScrollBar().setUnitIncrement(15);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVaciarCarrito = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelPeliculas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Carrito de Compras");

        btnVaciarCarrito.setText("Vaciar Carrito");
        btnVaciarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarCarritoActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPeliculasLayout = new javax.swing.GroupLayout(panelPeliculas);
        panelPeliculas.setLayout(panelPeliculasLayout);
        panelPeliculasLayout.setHorizontalGroup(
            panelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        panelPeliculasLayout.setVerticalGroup(
            panelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelPeliculas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(113, 113, 113)
                                .addComponent(btnVaciarCarrito)
                                .addGap(57, 57, 57)
                                .addComponent(btnComprar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnVaciarCarrito)
                    .addComponent(btnComprar))
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVaciarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarCarritoActionPerformed
		controladorVistaCarrito.vaciarCarrito();
		JOptionPane.showMessageDialog(null, "Se vació el carrito :'(");
		dibujarCarrito();
    }//GEN-LAST:event_btnVaciarCarritoActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
		VistaCompraPelicula vistaCompraPelicula = new VistaCompraPelicula();
		vistaCompraPelicula.setVisible(true);
		this.dispose();
    }//GEN-LAST:event_btnComprarActionPerformed

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
			java.util.logging.Logger.getLogger(VistaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(VistaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(VistaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(VistaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new VistaCarrito().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVaciarCarrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelPeliculas;
    // End of variables declaration//GEN-END:variables
}
