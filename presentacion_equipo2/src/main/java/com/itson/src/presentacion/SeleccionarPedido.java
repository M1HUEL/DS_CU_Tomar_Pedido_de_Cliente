package com.itson.src.presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import tomarPedido.objetosNegocio.Complemento;
import tomarPedido.objetosNegocio.Ingrediente;
import tomarPedido.objetosNegocio.Pedido;

/**
 *
 * @author Manuel Donato Hernandez Burgos
 */
public class SeleccionarPedido extends javax.swing.JFrame {

    public SeleccionarPedido() {
        initComponents();

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Seleccionar Pedido");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel pedidos = new JPanel();
        pedidos.setLayout(new GridLayout(3, 3, 10, 10));

        Ingrediente carneAsada = new Ingrediente(1, "Carne Asada", 25.0);
        Ingrediente tortillaMaiz = new Ingrediente(2, "Tortilla de maíz", 5.0);
        Ingrediente queso = new Ingrediente(3, "Queso rallado", 8.0);
        Ingrediente cebolla = new Ingrediente(4, "Cebolla picada", 3.0);
        Ingrediente cilantro = new Ingrediente(5, "Cilantro fresco", 2.0);
        Ingrediente guacamole = new Ingrediente(6, "Guacamole", 10.0);
        Ingrediente frijoles = new Ingrediente(7, "Frijoles refritos", 6.0);
        Ingrediente salsaVerde = new Ingrediente(8, "Salsa verde", 4.0);
        Ingrediente salsaRoja = new Ingrediente(9, "Salsa roja", 4.0);
        Ingrediente limon = new Ingrediente(10, "Rodajas de limón", 2.0);

        Complemento refresco = new Complemento(1, "Refresco", 15.0);
        Complemento papas = new Complemento(2, "Papas fritas", 20.0);
        Complemento postre = new Complemento(3, "Flan casero", 25.0);
        Complemento agua = new Complemento(4, "Agua natural", 10.0);
        Complemento cerveza = new Complemento(5, "Cerveza", 30.0);
        Complemento nachos = new Complemento(6, "Nachos con queso", 18.0);

        Pedido pedido1 = new Pedido();
        pedido1.setId(1);
        pedido1.setCliente("Juan Pérez");
        pedido1.setComentario("Hamburguesa bien cocida, sin cebolla");
        pedido1.getIngredientes().addAll(Arrays.asList(carneAsada, queso, guacamole));
        pedido1.getComplementos().addAll(Arrays.asList(refresco, papas));
        pedido1.setMonto(25.0 + 8.0 + 10.0 + 15.0 + 20.0);

        Pedido pedido2 = new Pedido();
        pedido2.setId(2);
        pedido2.setCliente("Ana López");
        pedido2.setComentario("Tacos con mucha salsa verde");
        pedido2.getIngredientes().addAll(Arrays.asList(tortillaMaiz, carneAsada, cebolla, cilantro, salsaVerde, limon));
        pedido2.getComplementos().addAll(Arrays.asList(refresco));
        pedido2.setMonto(5.0 + 25.0 + 3.0 + 2.0 + 4.0 + 2.0 + 15.0);

        Pedido pedido3 = new Pedido();
        pedido3.setId(3);
        pedido3.setCliente("Carlos Díaz");
        pedido3.setComentario("Sin salsa, agregar guacamole");
        pedido3.getIngredientes().addAll(Arrays.asList(frijoles, queso, guacamole, tortillaMaiz));
        pedido3.getComplementos().addAll(Arrays.asList(agua));
        pedido3.setMonto(6.0 + 8.0 + 10.0 + 5.0 + 10.0);

        Pedido pedido4 = new Pedido();
        pedido4.setId(4);
        pedido4.setCliente("Laura García");
        pedido4.setComentario("Agregar salsa roja extra picante");
        pedido4.getIngredientes().addAll(Arrays.asList(tortillaMaiz, carneAsada, salsaRoja, cebolla, cilantro, limon));
        pedido4.getComplementos().addAll(Arrays.asList(cerveza));
        pedido4.setMonto(5.0 + 25.0 + 4.0 + 3.0 + 2.0 + 2.0 + 30.0);

        Pedido pedido5 = new Pedido();
        pedido5.setId(5);
        pedido5.setCliente("Pedro Morales");
        pedido5.setComentario("Agregar extra queso");
        pedido5.getIngredientes().addAll(Arrays.asList(queso, guacamole, salsaVerde));
        pedido5.getComplementos().addAll(Arrays.asList(nachos, refresco));
        pedido5.setMonto(8.0 + 10.0 + 4.0 + 18.0 + 15.0);

        Pedido pedido6 = new Pedido();
        pedido6.setId(6);
        pedido6.setCliente("Sofía Ramírez");
        pedido6.setComentario("Para compartir, incluir servilletas extra");
        pedido6.getIngredientes().addAll(Arrays.asList(
                tortillaMaiz, carneAsada, cebolla, cilantro, salsaRoja, salsaVerde, limon
        ));
        pedido6.getComplementos().addAll(Arrays.asList(papas, refresco, postre));
        pedido6.setMonto(5.0 + 25.0 + 3.0 + 2.0 + 4.0 + 4.0 + 2.0 + 20.0 + 15.0 + 25.0);

        JButton button1 = new JButton("Pedido 1");
        JButton button2 = new JButton("Pedido 2");
        JButton button3 = new JButton("Pedido 3");
        JButton button4 = new JButton("Pedido 4");
        JButton button5 = new JButton("Pedido 5");
        JButton button6 = new JButton("Pedido 6");

        List<Pedido> listaPedidos = Arrays.asList(pedido1, pedido2, pedido3, pedido4, pedido5, pedido6);

        List<JButton> botones = Arrays.asList(button1, button2, button3, button4, button5, button6);

        for (int i = 0; i < botones.size(); i++) {
            Pedido pedido = listaPedidos.get(i);
            JButton boton = botones.get(i);

            boton.addActionListener(e -> {
                new PersonalizarPedido(pedido).setVisible(true);
            });

            pedidos.add(boton);
        }

        panel.add(titulo, BorderLayout.NORTH);
        panel.add(pedidos, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
