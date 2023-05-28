package proyectomundial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUIManual extends JFrame {

    static String B;
    static String Pais;
    static String continente;
    static String grupo;
    static String golesTex;
    static String marcador1 = "";
    static String marcador2 = "";
    static String partidos;
    static String promedioGoles = "";
    static String mayorCantidadGoles;
    static String menorCantidadGoles;
    static String partidosConGanador;
    static String partidosConEmpate;
    static String seleccionMasGoles;
    static String seleccionMenosGoles;
    static String continenteMasGoles;
    static String continenteMenosGoles;
    static String seleccionMasPuntos;
    static String seleccionMenosPuntos;
    static String clasificados;
    static String A1;
    static String B1;
    static String C1;
    static String D1;
    static String E1;

    static int puntos = 0;
    static int masPuntos = 0;
    static int menosPuntos = 0;
    static int fila = 0;
    static int columna = 0;
    static int golesInt = 0;
    static int masG = 0;
    static int menosG = 0;

    static int contador1 = 0;
    static int contador2 = 0;
    static int suma = 0;
    static int masGoles = 0;
    static int menosGoles = 0;
    static int golesLoc = 0;
    static int golesVic = 0;
    static double totalGoles = 0;

    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int A = 0;
    static int C = 0;
    static int D = 0;
    static int E = 0;
    static int F = 0;

    static int z = 0;
    static int h = 0;
    static int x = 0;
    static int w = 0;
    static int g = 0;

    // Matrix que permite almancenar la información de las selecciones futbol cargadas, grupos y marcadores
    public String[][] selecciones = null;

    // Matriz que permite almacenar los resultados de los partidos cargardos
    public String[][] resultados = null;

    // Matrix que permite almancenar la información de las selecciones futbol cargadas
    public String[][] seleccionesFiltro = null;
    public String[][] resultadosFiltro = null;
    public String[][] grupos = null;
    public String[][] datos = null;
    public String[][] marcadores = null;
    public String[][] Matcontinentes = null;
    public String[][] continentesL = null;

    // Elementos de barra Lateral
    private JPanel jPanelLeft;

    private JPanel jPanelIconFIFA;
    private JLabel iconFIFA;

    // Elementos de opciones de Menú
    private JPanel jPanelMenu;

    private JPanel jPanelMenuHome;
    private JLabel btnHome;

    private JPanel jPanelMenuSelecciones;
    private JLabel btnSelecciones;

    private JPanel jPanelMenuResultados;
    private JLabel btnResultados;

    private JPanel jPanelMenuDashboardSel;
    private JLabel btnDashboardSel;

    private JPanel jPanelMenuDashboardRes;
    private JLabel btnDashboardRes;

    private JPanel jPanelMenuParcial;
    private JLabel btnParcial;

    // Elementos de panel de contenido
    private JPanel jPanelRight;
    private JPanel jPanelLabelTop;
    private JLabel jLabelTop;

    private JPanel jPanelMain;

    public GUIManual() {

        // Se inician los componentes gráficos
        initComponents();

        // Se configuran propiedades de nuestra Ventana
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Se llama la función home para que al momento de iniciar la aplicacoón, por defecto se muestre el home
        accionHome();

    }

    private void initComponents() {

        // Inicializamos componentes del Menu Lateral
        jPanelLeft = new JPanel();

        jPanelIconFIFA = new JPanel();
        iconFIFA = new JLabel();
        jPanelMenu = new JPanel();

        jPanelMenuHome = new JPanel();
        btnHome = new JLabel();

        jPanelMenuSelecciones = new JPanel();
        btnSelecciones = new JLabel();

        jPanelMenuResultados = new JPanel();
        btnResultados = new JLabel();

        jPanelMenuDashboardSel = new JPanel();
        btnDashboardSel = new JLabel();

        jPanelMenuDashboardRes = new JPanel();
        btnDashboardRes = new JLabel();

        jPanelMenuParcial = new JPanel();
        btnParcial = new JLabel();

        // Pinta el logo de la aplicación
        pintarLogo();

        // Pinta la opción de menú del Home
        pintarMenuHome();

        // Pinta la opción de Menú de las Selecciones
        pintarMenuSelecciones();

        // Pinta la opción de Menú de los resultados
        pintarMenuResultados();

        // Pinta la opción de Menú del dashboard de equipo
        pintarMenuDashboardSel();

        // Pinta la opción de Menú del dahboard de resultados
        pintarMenuDashboardRes();

        // Pinta la opción de Menú parcial
        pintarMenuParcial();

        // Pinta y ajuste diseño del contenedor del panel izquierdo
        pintarPanelIzquierdo();

        // Inicializa los componentes del panel derecho de los contenidos
        jPanelRight = new JPanel();
        jPanelLabelTop = new JPanel();
        jPanelMain = new JPanel();

        // Pinta la barra superrior de color azul claro, del panel de contenido
        pintarLabelTop();

        // Pinta y ajusta diseño del contenedor de contenidos
        pintarPanelDerecho();

        setTitle("Mundial");
        pack();
        setVisible(true);
    }

    private void pintarLogo() {
        jPanelIconFIFA.add(iconFIFA);
        jPanelIconFIFA.setOpaque(false);
        jPanelIconFIFA.setPreferredSize((new java.awt.Dimension(220, 80)));
        jPanelIconFIFA.setMaximumSize(jPanelIconFIFA.getPreferredSize());
        iconFIFA.setIcon(new ImageIcon(getClass().getResource("/resources/Easports_fifa_logo.svg.png")));
        jPanelLeft.add(jPanelIconFIFA, BorderLayout.LINE_START);

    }

    /**
     * Función que se encarga de ajustar los elementos gráficos que componente
     * la opción de navegación del HOME Define estilos, etiquetas, iconos que
     * decoran la opción del Menú. Esta opción de Menu permite mostrar la página
     * de bienvenida de la aplicación
     */
    private void pintarMenuHome() {
        btnHome.setIcon(new ImageIcon(getClass().getResource("/resources/icons/home.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioHome = new JLabel();
        jPanelMenuHome.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuHome.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuHome.setLayout(new BorderLayout(15, 0));
        jPanelMenuHome.add(vacioHome, BorderLayout.WEST);
        jPanelMenuHome.add(btnHome, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuHome);

        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Home");
                A++;
                A1 = String.valueOf(A);
                accionHome();
            }
        });
    }

    /**
     * Función que se ejecuta cuando el usuario hacer click sobre la opción de
     * navegación Home Permite modificar la etiqueta de Navegación en Home,
     * remover los elementos que hay en el panel de contenidos y agregar la
     * imagen de inicio de la aplicación
     */
    private void accionHome() {
        jLabelTop.setText("Home");
        //jLabelTopDescription.setText("Bievenido al sistema de gestión de mundiales de fútbol");
        btnHome.setForeground(new java.awt.Color(255, 255, 255));

        jPanelMain.removeAll();
        JPanel homePanel = new JPanel();
        JLabel imageHome = new JLabel();

        imageHome.setIcon(new ImageIcon(getClass().getResource("/resources/home1.jpg"))); // NOI17N
        imageHome.setPreferredSize(new java.awt.Dimension(910, 465));
        homePanel.add(imageHome);

        jPanelMain.add(homePanel, BorderLayout.CENTER);
        jPanelMain.repaint();
        jPanelMain.revalidate();

    }

    /**
     * Función que se encarga de ajustar los elementos gráficos que componen la
     * opción de navegación de SELECCIONES Define estilos, etiquetas, iconos que
     * decoran la opción del Menú. Esta opción de Menu permite mostrar las
     * selecciones de futbol cargadas en la aplicación
     */
    private void pintarMenuSelecciones() {

        btnSelecciones.setIcon(new ImageIcon(getClass().getResource("/resources/icons/selecciones.png"))); // NOI18N
        btnSelecciones.setText("Selecciones");
        btnSelecciones.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioSelecciones = new JLabel();
        //Pinta el color del fondo en el boton  
        jPanelMenuSelecciones.setBackground(new java.awt.Color(17, 41, 63));
        //Adapta la dimension del texto en el boton y lo ubica al lado izquierdo
        jPanelMenuSelecciones.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuSelecciones.setLayout(new BorderLayout(15, 0));
        //Alinea la posicion de los textos en los botones  
        jPanelMenuSelecciones.add(vacioSelecciones, BorderLayout.WEST);
        //Pinta el texto en el boton y lo posiciona  
        jPanelMenuSelecciones.add(btnSelecciones, BorderLayout.CENTER);
        //Pinta el boton y lo posiciona    
        jPanelMenu.add(jPanelMenuSelecciones);

        btnSelecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Selecciones");
                C++;
                B1 = String.valueOf(C);
                accionHome();
                accionSelecciones();

            }
        });
    }

    /**
     * Función que se ejecuta cuando el usuario hace click sobre la opción de
     * navegación Selecciones Permite ver la lista de selecciones que se
     * encuentran cargadas en la aplicación. Si la lista de selecciones es
     * vacía, muestra un botón que permite cargar un archivo CSV con la
     * información de las selelecciones
     */
    private void accionSelecciones() {
        //Se reemplaza el texto de home por selecciones en el cuadro  
        jLabelTop.setText("selecciones");

        if (selecciones == null) {
            jPanelMain.removeAll();
            JPanel seleccionesPanel = new JPanel();

            if (selecciones == null) {
                JLabel notSelecciones = new JLabel();
                notSelecciones.setText("No hay selecciones cargadas, por favor cargue selecciones \n\n");
                seleccionesPanel.add(notSelecciones);

                JButton cargarFile = new JButton();
                cargarFile.setText("Seleccione el archivo");
                seleccionesPanel.add(cargarFile);

                cargarFile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        cargarFileSelecciones();
                    }
                });
            } else {
            }
            jPanelMain.add(seleccionesPanel);
            jPanelMain.repaint();
            jPanelMain.revalidate();
        } // Si hay selecciones cargadas, llama el método que permite pintar la tabla de selecciones
        else {
            pintarTablaSelecciones();
        }
    }

    /**
     * Función que se encarga de ajustar los elementos gráficos que componen la
     * opción de navegación de RESULTADOS Define estilos, etiquetas, iconos que
     * decoran la opción del Menú. Esta opción de Menu permite mostrar los
     * diferentes resultados de los partidos de la fase de grupos de un mundial
     */
    private void pintarMenuResultados() {
        btnResultados.setIcon(new ImageIcon(getClass().getResource("/resources/icons/resultados.png"))); // NOI18N
        btnResultados.setText("Resultados");
        btnResultados.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioResultados = new JLabel();
        jPanelMenuResultados.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuResultados.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuResultados.setLayout(new BorderLayout(15, 0));
        jPanelMenuResultados.add(vacioResultados, BorderLayout.WEST);
        jPanelMenuResultados.add(btnResultados, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuResultados);

        btnResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D++;
                C1 = String.valueOf(D);
                accionResultados();
            }
        });
    }

    /**
     * Función que se ejecuta cuando el usuario hace click sobre la opción de
     * navegación Resultados Permite ver la lista de resultados que se
     * encuentran cargadas en la aplicación. Si la lista de resultados es vacía,
     * muestra un botón que permite cargar un archivo CSV con la información de
     * los resultados
     */
    private void accionResultados() {
        jLabelTop.setText("Resultados");

        // Si no hay resultados cargados, muestra el botón de carga de resultados
        if (resultados == null) {
            jPanelMain.removeAll();
            JPanel resultadosPanel = new JPanel();

            if (resultados == null) {

                JLabel notResultados = new JLabel();
                notResultados.setText("No hay resultados, por favor cargue resultados \n\n");
                resultadosPanel.add(notResultados);

                JButton cargarFile = new JButton();
                cargarFile.setText("Seleccione el archivo");
                resultadosPanel.add(cargarFile);
                cargarFile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        cargarFileResultados();
                    }
                });
            }

            jPanelMain.add(resultadosPanel);
            jPanelMain.repaint();
            jPanelMain.revalidate();
        } // Si hay ressultados cargados, llama el método que permite pintar la tabla de resultados
        else {
            pintarTablaResultados();
        }
    }

    /**
     * Función que se encarga de ajustar los elementos gráficos que componente
     * la opción de navegación de Dashboard de Selecciones Define estilos,
     * etiquetas, iconos que decoran la opción del Menú. Esta opción de Menu
     * permite mostrar los diferentes datos que será extraidos de la información
     * de las selecciones de futbol que fueron cargadas
     */
    private void pintarMenuDashboardSel() {
        btnDashboardSel.setIcon(new ImageIcon(getClass().getResource("/resources/icons/dashboard_selecciones.png")));
        btnDashboardSel.setText("Dash Selecciones");
        btnDashboardSel.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioDashboardSelecciones = new JLabel();
        jPanelMenuDashboardSel.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuDashboardSel.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuDashboardSel.setLayout(new BorderLayout(15, 0));
        jPanelMenuDashboardSel.add(vacioDashboardSelecciones, BorderLayout.WEST);
        jPanelMenuDashboardSel.add(btnDashboardSel, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuDashboardSel);

        btnDashboardSel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Dashboard Selecciones");
                E++;
                D1 = String.valueOf(E);
                accionDashboardSel();
            }
        });
    }

    private void accionDashboardSel() {

        jLabelTop.setText("D.Tecnicos X  - PAIS(ES) -  X CONTINENTE");
        String[] columnNames = {"América Central", "Asia", "África", "América del Sur", "América del Norte", "Oceanía", "Europa ", "Total DT"};
        String[][] continentes = new String[32][8];
        grupos();

        contador1 = 0;

        for (int i = 0; i < continentesL.length; i++) {
            fila = 0;

            for (int j = 0; j < selecciones.length; j++) {
                contador1 = 0;
                if (selecciones[j][2].equals(continentesL[i][0])) {     //presgunta si la posicion de la matriz continentes es igual a la variable continente
                    continentes[fila][i] = selecciones[j][1];

                    for (int k = 0; k < selecciones.length; k++) {
                        if (selecciones[k][4].equals(selecciones[j][1])) {
                            contador1++;
                        }
                        if (k == selecciones.length - 1) {
                            fila++;
                            continentes[fila][i] = String.valueOf(contador1 + " D.T");
                            fila++;
                            suma = suma + contador1;
                        }
                    }
                }
            }
            continentes[0][7] = String.valueOf(suma + " DT");
        }

        JTable table = new JTable(continentes, columnNames);
        //Alto de las celdas
        table.setRowHeight(20);

        //    JPanel form = new JPanel();
        //    form.setLayout(new GridLayout(4, 1, 0, 0));
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 30, 0));

        JPanel seleccionesPanel = new JPanel();
        seleccionesPanel.setLayout(new BoxLayout(seleccionesPanel, BoxLayout.Y_AXIS));
        seleccionesPanel.setPreferredSize((new java.awt.Dimension(910, 450)));
        seleccionesPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        //    seleccionesPanel.add(form);
        seleccionesPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(seleccionesPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();

    }

    private void pintarMenuDashboardRes() {
        btnDashboardRes.setIcon(new ImageIcon(getClass().getResource("/resources/icons/dashboard_resultados.png")));
        btnDashboardRes.setText("Dash Resultados");
        btnDashboardRes.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioDashboardResultados = new JLabel();
        jPanelMenuDashboardRes.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuDashboardRes.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuDashboardRes.setLayout(new BorderLayout(15, 0));
        jPanelMenuDashboardRes.add(vacioDashboardResultados, BorderLayout.WEST);
        jPanelMenuDashboardRes.add(btnDashboardRes, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuDashboardRes);

        btnDashboardRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Dashboard Resultados");
                accionDashboardRes();
                F++;
                E1 = String.valueOf(F);
            }
        });
    }

    private void calcularPuntos() {

        marcadores = new String[32][7];

        int guardarFila = 0;
        columna = 1;
        fila = 0;
        suma = 0;

        grupo = grupos[0][0];

        while (fila < 45) {                                                            //capto de cada fila los paises que se enfrentan ella

            Pais = resultados[fila][columna];
            puntos = 0;
            guardarFila = fila;                                                        //variable en la que guardo la posicion de la fila general

            while (contador1 < 6) {                                                    //recorro las 6 filas de cada grupo para optener puntos
                golesLoc = 0;                                                          //variable que convierte a entero el numero de golesTex marcado por cada equipo en su grupo 
                golesVic = 0;

                //segun el resultados en golesTex de los partidos, calculo cantidad de puntos optenidos por equipo
                if (resultados[fila][1].equals(Pais) || resultados[fila][2].equals(Pais)) {
                    if (resultados[fila][1].equals(Pais)) {
                        golesLoc = Integer.parseInt(resultados[fila][5]);
                        golesVic = Integer.parseInt(resultados[fila][6]);
                        suma = suma + golesLoc;
                        golesTex = String.valueOf(suma);
                        contador2++;
                        golesInt = golesLoc + golesVic;
                        if (contador2 < 2) {
                            menosGoles = golesInt;
                        }
                        if (golesInt > masGoles) {
                            masGoles = golesInt;

                        } else {
                            if (golesInt < menosGoles) {
                                menosGoles = golesInt;
                            }
                        }

                        if (golesLoc > golesVic) {
                            puntos = puntos + 3;
                        } else {
                            if (golesVic > golesLoc) {
                            } else {
                                puntos = puntos + 1;

                            }
                        }
                    } else {
                        golesLoc = Integer.parseInt(resultados[fila][6]);                                                //se crea una variable que va a guardar el nombre de cada continente 
                        golesVic = Integer.parseInt(resultados[fila][5]);
                        suma = suma + golesLoc;
                        golesTex = String.valueOf(suma);
                        if (golesLoc > golesVic) {
                            puntos = puntos + 3;

                        } else {
                            if (golesVic > golesLoc) {
                            } else {
                                puntos = puntos + 1;

                            }
                        }
                    }
                }
                contador1++;
                fila++;
                if (fila == 48) {
                    contador1 = 6;
                    z++;
                }
            }

            //segun resultados se va llenando la matriz marcadores 
            contador1 = 0;
            B = String.valueOf(puntos);
            a = 0;
            marcadores[b][a] = grupo;
            a++;
            marcadores[b][a] = Pais;
            a++;
            marcadores[b][a] = B;
            a++;
            marcadores[b][a] = String.valueOf(golesTex);;
            suma = 0;
            marcadores[0][5] = partidos;
            b++;

            if (columna == 2) {
                h++;
                fila = guardarFila + 1;
                columna = 0;
                if (h == 2) {
                    x++;
                    h = 0;
                    fila = fila + 4;
                    if (x == 8) {
                        x = 7;
                    }

                    grupo = grupos[x][0];
                }
            } else {
                fila = guardarFila;
            }
            columna++;
        }
        masGoles = 0;
        menosGoles = 0;
    }

    private void calcularClasificados() {

        a = 1;

        for (int i = 0; i <= 28; i += 4) {

            A = 0;
            C = 0;
            D = 0;
            b = 0;
            A = Integer.parseInt(marcadores[i][2]);

            for (int j = a; j < 33; j++) {
                C = Integer.parseInt(marcadores[j][2]);
                if (A >= C) {
                    if (C > D) {
                        D = C;
                    }
                } else {
                    if (C >= A) {
                        D = A;
                        A = C;
                    }
                }
                b++;
                if (b == 3) {
                    marcador1 = String.valueOf(A);
                    marcador2 = String.valueOf(D);
                    int a = 0;
                    for (w = g; w < 32; w++) {
                        if (marcadores[w][2].equals(marcador1) || marcadores[w][2].equals(marcador2)) {
                            if (marcadores[w][2].equals(marcador1)) {
                                marcadores[w][4] = "clasificado";
                            } else {
                                marcadores[w][4] = "clasificado";
                            }
                        }
                        a++;
                        g++;
                        if (a == 4) {
                            break;
                        }
                    }
                    break;
                }
                a++;
            }
            a = a + 2;
        }
    }

    private void grupos() {

        grupos = new String[8][4];

        grupos[0][0] = "A";
        grupos[1][0] = "B";
        grupos[2][0] = "C";
        grupos[3][0] = "D";
        grupos[4][0] = "E";
        grupos[5][0] = "F";
        grupos[6][0] = "G";
        grupos[7][0] = "H";

        continentesL = new String[7][1];

        continentesL[0][0] = "América Central";
        continentesL[1][0] = "Asia";
        continentesL[2][0] = "África";
        continentesL[3][0] = "América del Sur";
        continentesL[4][0] = "América del Norte";
        continentesL[5][0] = "Oceanía";
        continentesL[6][0] = "Europa";

    }

    private void promedioDeGoles() {

        DecimalFormat formato = new DecimalFormat("#.00");
        totalGoles = 0;

        for (int i = 0; i < resultados.length; i++) {
            golesLoc = Integer.parseInt(resultados[i][5]);
            golesVic = Integer.parseInt(resultados[i][6]);
            suma = golesLoc + golesVic;
            totalGoles = totalGoles + suma;

            if (i == 47) {
                totalGoles = totalGoles / 48;
                promedioGoles = String.valueOf(formato.format(totalGoles));
            }
        }
        marcadores[2][5] = "Promedio de Goles";
        marcadores[3][5] = promedioGoles;
        System.out.println(promedioGoles);
    }

    private void partidoConMasyMenosGoles() {

        menosGoles = suma;

        for (int i = 0; i < resultados.length; i++) {
            Pais = (resultados[i][1] + " Vs " + resultados[i][2]);
            golesLoc = Integer.parseInt(resultados[i][5]);
            golesVic = Integer.parseInt(resultados[i][6]);
            suma = golesLoc + golesVic;

            if (suma > masGoles) {
                masGoles = suma;
                mayorCantidadGoles = (Pais + ", " + masGoles);
            } else {
                if (suma < menosGoles) {
                    menosGoles = suma;
                    menorCantidadGoles = (Pais + ", " + menosGoles);
                }
            }
        }
        marcadores[11][5] = "Partidos con mas Goles";
        marcadores[12][5] = mayorCantidadGoles;
        marcadores[14][5] = "Partidos con menos Goles";
        marcadores[15][5] = menorCantidadGoles;

        System.out.println("\nPartido Con Mayor Cantidad de Goles\n" + mayorCantidadGoles);
        System.out.println("\nPartido Con Menor Cantidad de Goles\n" + menorCantidadGoles);

    }

    private void partidoConGanadorOEmpate() {

        contador1 = 0;
        contador2 = 0;

        for (int i = 0; i < resultados.length; i++) {
            golesLoc = Integer.parseInt(resultados[i][5]);
            golesVic = Integer.parseInt(resultados[i][6]);

            if (golesLoc > golesVic || golesLoc < golesVic) {
                contador1++;
                partidosConGanador = String.valueOf(contador1);
                marcadores[5][5] = "Partidos con ganador";
                marcadores[6][5] = partidosConGanador;
            } else {
                contador2++;
                partidosConEmpate = String.valueOf(contador2);
                marcadores[8][5] = "Partidos con empate";
                marcadores[9][5] = partidosConEmpate;
            }

        }
        System.out.println("\nPartidos con ganador  " + partidosConGanador);
        System.out.println("Partidos con empate  " + partidosConEmpate);
    }

    private void seleccionConMasyMenosGoles() {

        String[][] equipoConMasyMenosGoles = new String[14][2];
        
        int a = 27;
        golesInt = 0;
        menosGoles = 8;
        masGoles = 0;
        contador1 = 0;
        contador2 = 0;

        while (contador2 < 3) {

            for (int j = 0; j < marcadores.length; j++) {
                golesInt = Integer.parseInt(marcadores[j][3]);
                if (golesInt >= masGoles) {
                    masGoles = golesInt;
                    if (contador2 == 1) {
                        seleccionMasGoles = (marcadores[j][1] + "  =  " + marcadores[j][3]);
                        equipoConMasyMenosGoles[contador1][0] = marcadores[j][1];
                        equipoConMasyMenosGoles[contador1][1] = marcadores[j][3];
                        marcadores[23][5] = "Selec. con mas Goles";
                        marcadores[24][5] = seleccionMasGoles;
                        contador1++;

                    }
                }
                if (golesInt <= menosGoles) {
                    menosGoles = golesInt;
                    if (contador2 == 2) {
                        seleccionMenosGoles = (marcadores[j][1] + "  =  " + marcadores[j][3]);
                        equipoConMasyMenosGoles[contador1][0] = marcadores[j][1];
                        equipoConMasyMenosGoles[contador1][1] = marcadores[j][3];
                        marcadores[26][5] = "Selec. con menos Goles";
                        if (a < 32) {
                            marcadores[a][5] = seleccionMenosGoles;
                            a++;
                        }
                        contador1++;

                    }
                }
            }
            contador2++;
        }
        contador1 = 0;

        for (int i = 0; i < equipoConMasyMenosGoles.length; i++) {

            if (i == 0) {
                System.out.println("\nseleccion con mas y menos Goles");
            }
            System.out.println(equipoConMasyMenosGoles[i][0] + "  " + equipoConMasyMenosGoles[i][1]);
        }
    }

    private void seleccionConMasyMenosPuntos() {

        String[][] seleccionConMasyMenosPuntos = new String[5][2];

        menosPuntos = 1;

        int a = 0;
        masG = 0;
        menosG = 8;
        int contador = 0;

        while (contador < 3) {

            for (int j = 0; j < marcadores.length; j++) {
                puntos = Integer.parseInt(marcadores[j][2]);
                if (puntos >= masPuntos) {
                    masPuntos = puntos;
                    if (contador == 1) {
                        seleccionMasPuntos = ("Seleccion con mas puntos:  " + marcadores[j][1] + "  =  " + marcadores[j][2]);
                        seleccionConMasyMenosPuntos[a][0] = marcadores[j][1];
                        seleccionConMasyMenosPuntos[a][1] = marcadores[j][2];
                        a++;
                    }
                }
                if (puntos <= menosPuntos) {
                    menosPuntos = puntos;
                    if (contador == 2) {
                        seleccionMenosPuntos = ("Seleccion con menos puntos:  " + marcadores[j][1] + "  =  " + marcadores[j][2]);
                        seleccionConMasyMenosPuntos[a][0] = marcadores[j][1];
                        seleccionConMasyMenosPuntos[a][1] = marcadores[j][2];
                        a++;
                    }
                }
            }
            contador++;
        }
        a = 0;

        for (int i = 0; i < seleccionConMasyMenosPuntos.length; i++) {

            if (i == 0) {
                System.out.println("\nseleccion con mas y menos puntos  ");
            }
            System.out.println(seleccionConMasyMenosPuntos[i][0] + "  " + seleccionConMasyMenosPuntos[i][1]);
        }
    }

    private void continenteConMasyMenosGoles() {

        Matcontinentes = new String[7][2];
        continente = "";
        A = 0;
        C = 0;
        suma = 0;
        golesInt = 0;
        menosGoles = 8;
        masGoles = 0;
        contador1 = 0;
        contador2 = 0;

        for (int i = 0; i < continentesL.length; i++) {
            Matcontinentes[i][0] = continentesL[i][0];

            for (int j = 0; j < resultados.length; j++) {
                if (resultados[j][3].equals(continentesL[i][0]) || resultados[j][4].equals(continentesL[i][0])) {
                    if (resultados[j][3].equals(continentesL[i][0])) {
                        golesInt = Integer.parseInt(resultados[j][5]);
                        golesTex = String.valueOf(suma = suma + golesInt);
                    } else {
                        golesInt = Integer.parseInt(resultados[j][6]);                                                //se crea una variable que va a guardar el nombre de cada continente 
                        golesTex = String.valueOf(suma = suma + golesInt);
                    }
                }
            }
            golesInt = 0;
            Matcontinentes[i][1] = golesTex;
        }

        for (int j = 0; j < Matcontinentes.length; j++) {
            golesInt = Integer.parseInt(Matcontinentes[j][1]);
            for (int i = 1; i < Matcontinentes.length; i++) {
                golesLoc = Integer.parseInt(Matcontinentes[i][1]);
                if (golesInt > golesLoc && golesInt > masGoles) {
                    masGoles = golesInt;
                    continenteMasGoles = String.valueOf(Matcontinentes[j][0] + "  = " + masGoles);
                    if (j == 0 && i == 0) {
                        menosGoles = masGoles;
                    }
                } else {
                    if (menosGoles > golesInt) {
                        menosGoles = golesInt;
                        continenteMenosGoles = String.valueOf(Matcontinentes[j][0] + "  = " + menosGoles);

                    }

                }
            }
        }
        marcadores[17][5] = "Cont. menos Goles";
        marcadores[18][5] = continenteMenosGoles;
        marcadores[20][5] = "Cont. mas Goles";
        marcadores[21][5] = continenteMasGoles;

        System.out.println(continenteMasGoles + "\n\n" + continenteMenosGoles);

    }

    private void accionDashboardRes() {

        jLabelTop.setText("Datos estadisticos");

        String[] columnNames = {"grupo", "Pais", "Puntos", "# Goles", "Clasificados", "Partidos Jugados"};
        String[][] clasificados = new String[16][2];
        marcador1 = "";
        marcador2 = "";
        a = 0;
        D = 0;
        E = 0;

        grupos();

        partidos = String.valueOf(resultados.length);
        System.out.println(partidos);

        calcularPuntos();

        calcularClasificados();

        promedioDeGoles();

        partidoConMasyMenosGoles();

        partidoConGanadorOEmpate();

        seleccionConMasyMenosGoles();

        seleccionConMasyMenosPuntos();

        continenteConMasyMenosGoles();

        JTable table = new JTable(marcadores, columnNames);

        table.setRowHeight(20);
        JPanel marcadoresPanel = new JPanel();
        marcadoresPanel.setLayout(new BoxLayout(marcadoresPanel, BoxLayout.Y_AXIS));
        marcadoresPanel.setPreferredSize((new java.awt.Dimension(910, 450)));
        marcadoresPanel.setMaximumSize(jPanelRight.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);

        marcadoresPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(marcadoresPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();

    }

    /**
     * Función que permite darle estilos y agregar los componentes gráficos del
     * contendor de la parte izquierda de la interfaz, dónde se visulaiza el
     * menú de navegaación
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void pintarMenuParcial() {
        btnParcial.setIcon(new ImageIcon(getClass().getResource("/resources/icons/home.png"))); // NOI18N
        btnParcial.setText("Parcial");
        btnParcial.setForeground(new java.awt.Color(255, 255, 255));

        JLabel vacioParcial = new JLabel();
        jPanelMenuParcial.setBackground(new java.awt.Color(17, 41, 63));
        jPanelMenuParcial.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuParcial.setLayout(new BorderLayout(15, 0));
        jPanelMenuParcial.add(vacioParcial, BorderLayout.WEST);
        jPanelMenuParcial.add(btnParcial, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuParcial);

        btnParcial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Parcial");
                accionParcial();
            }
        });
    }

    private void accionParcial() {

        jLabelTop.setText("Parcial");

        String[] nameColumnas = {"Boton", "cantidad de ingreso"};
        datos = new String[5][2];

        datos[0][0] = "Home";
        datos[1][0] = "selecciones";
        datos[2][0] = "Resultados";
        datos[3][0] = "Dash selecciones";
        datos[4][0] = "Dash resultados";
        datos[0][1] = A1;
        datos[1][1] = B1;
        datos[2][1] = C1;
        datos[3][1] = D1;
        datos[4][1] = E1;

        JTable table = new JTable(datos, nameColumnas);
        table.setRowHeight(20);

        JPanel parcialPanel = new JPanel();
        parcialPanel.setLayout(new BoxLayout(parcialPanel, BoxLayout.Y_AXIS));
        parcialPanel.setPreferredSize((new java.awt.Dimension(910, 450)));
        parcialPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        parcialPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(parcialPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    private void pintarPanelIzquierdo() {
        // Se elimina el color de fondo del panel del menú
        jPanelMenu.setOpaque(false);

        // Se agrega un border izquierdo, de color blanco para diferenciar el panel de menú del panel de contenido
        jPanelLeft.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.WHITE));

        // Se define un BoxLayot de manera vertical para los elementos del panel izquierdo
        jPanelLeft.setLayout(new BoxLayout(jPanelLeft, BoxLayout.Y_AXIS));
        jPanelLeft.setBackground(new java.awt.Color(0, 24, 47));
        getContentPane().add(jPanelLeft, java.awt.BorderLayout.LINE_START);
        jPanelLeft.add(jPanelMenu);
        jPanelLeft.setPreferredSize((new java.awt.Dimension(220, 540)));
        jPanelLeft.setMaximumSize(jPanelLeft.getPreferredSize());
    }

    /**
     * Función que permite leer un archivo y procesar el contenido que tiene en
     * cada una de sus líneas El contenido del archivo es procesado y cargado en
     * la matriz de selecciones. Una vez la información se carga en la matriz,
     * se hace un llamado a la función pintarTablaSelecciones() que se encarga
     * de pintar en la interfaz una tabla con la información almacenada en la
     * matriz de selecciones
     */
    public void cargarFileSelecciones() {

        JFileChooser cargarFile = new JFileChooser();
        cargarFile.showOpenDialog(cargarFile);

        Scanner entrada = null;
        try {

            // Se obtiene la ruta del archivo seleccionado
            String ruta = cargarFile.getSelectedFile().getAbsolutePath();

            // Se obtiene el archivo y se almancena en la variable f
            File f = new File(ruta);
            entrada = new Scanner(f);

            // Se define las dimensiones de la matriz de selecciones
            selecciones = new String[32][5];

            // Permite que el sistema se salte la léctura de los encabzados del archivo CSV
            entrada.nextLine();

            int i = 0;
            // Se leen cada unas de las líneas del archivo
            while (entrada.hasNext()) {
                System.out.println(i);
                String line = entrada.nextLine();
                String[] columns = line.split(",");

                for (int j = 0; j < columns.length; j++) {
                    selecciones[i][j] = columns[j];
                }
                i++;
            }

            pintarTablaSelecciones();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
        pintarTablaSelecciones();

    }

    /**
     * Función que se encarga de pinta la tabla con la información de las
     * selelceciones que fue cargada previamente La tabla tiene definido un
     * encabezado con las siguentes columnas: {"ID","Selección", "Continente",
     * "DT", "Nacionalidad DT"} Columnas que se corresponden son la información
     * que fue leida desde el archivo csv
     */
    public void pintarTablaSelecciones() {

        pintarDetalleTablas(selecciones);
    }

    public void filtrarSelecciones(String cadena) {

        seleccionesFiltro = new String[32][5];

        int j = 0;

        for (int i = 0; i < selecciones.length; i++) {
            String[] seleccion = selecciones[i];
            //if(seleccion[1].contentEquals(cadena) || seleccion[2].contentEquals(cadena)) {
            if (seleccion[1].contains(cadena) || seleccion[2].contains(cadena)) {
                seleccionesFiltro[j] = seleccion;
                j++;
            }
        }

        String[][] seleccionesFinal = Arrays.copyOfRange(seleccionesFiltro, 0, j);

        pintarDetalleTablas(seleccionesFinal);

    }

    private void pintarDetalleTablas(String[][] selecciones) {
        String[] columnNames = {"ID", "Selección", "Continente", "DT", "Nacionalidad DT"};

        JTable table = new JTable(selecciones, columnNames);
        table.setRowHeight(30);

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(4, 1, 0, 0));

        JLabel label = new JLabel();
        label.setText("Busqueda de Equipos");
        form.add(label);

        JTextField field = new JTextField();
        form.add(field);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 30, 0));

        JButton buscar = new JButton();
        buscar.setText("Buscar");
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String valorBusqueda = field.getText();
                filtrarSelecciones(valorBusqueda);
            }
        });
        panelBotones.add(buscar);

        JButton limpiar = new JButton();
        limpiar.setText("Ver Todos");
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pintarTablaSelecciones();
            }
        });
        panelBotones.add(limpiar);
        form.add(panelBotones);

        JPanel seleccionesPanel = new JPanel();
        seleccionesPanel.setLayout(new BoxLayout(seleccionesPanel, BoxLayout.Y_AXIS));
        seleccionesPanel.setPreferredSize((new java.awt.Dimension(910, 490)));
        seleccionesPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        seleccionesPanel.add(form);
        seleccionesPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(seleccionesPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    /**
     * Función que tiene la lógica que permite leer un archivo CSV de resultados
     * y cargarlo sobre la matriz resultados que se tiene definida cómo variable
     * global. Luego de cargar los datos en la matriz, se llama la función
     * pintarTablaResultados() que se encarga de visulizar el contenido de la
     * matriz en un componente gráfico de tabla
     */
    public void cargarFileResultados() {

        JFileChooser cargarFile = new JFileChooser();
        cargarFile.showOpenDialog(cargarFile);

        Scanner entrada = null;
        try {
            // Se obtiene la ruta del archivo seleccionado
            String ruta = cargarFile.getSelectedFile().getAbsolutePath();

            // Se obtiene el archivo y se almancena en la variable f
            File f = new File(ruta);
            entrada = new Scanner(f);

            // Se define las dimensiones de la matriz de selecciones
            resultados = new String[48][7];
            entrada.nextLine();

            int i = 0;
            // Se iteran cada una de las líneas del archivo
            while (entrada.hasNext()) {
                System.out.println(i);
                String line = entrada.nextLine();
                String[] columns = line.split(",");

                for (int j = 0; j < columns.length; j++) {
                    resultados[i][j] = columns[j];
                }
                i++;
            }

            pintarTablaResultados();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }

    /**
     * Función que se encarga de pintar la tabla con la información de los
     * resultados que fue cargada previamente La tabla tiene definido un
     * encabezado con las siguentes columnas: {"Grupo","Local", "Visitante",
     * "Continente L", "Continente V", "Goles L", "Goles V"} Columnas que se
     * corresponden son la información que fue leida desde el archivo csv
     */
    public void pintarTablaResultados() {

        pintarDetalleTabla2(resultados);
    }

    public void filtrarResultados(String cadena) {

        seleccionesFiltro = new String[32][5];

        int j = 0;

        for (int i = 0; i < resultados.length; i++) {
            String[] seleccion = resultados[i];
            //if(seleccion[1].contentEquals(cadena) || seleccion[2].contentEquals(cadena)) {
            if (seleccion[1].contains(cadena) || seleccion[2].contains(cadena)) {
                seleccionesFiltro[j] = seleccion;
                j++;
            }
        }

        String[][] seleccionesFinal = Arrays.copyOfRange(seleccionesFiltro, 0, j);

        pintarDetalleTabla2(seleccionesFinal);

    }

    private void pintarDetalleTabla2(String[][] resultados) {

        String[] columnNames = {"Grupo", "Local", "Visitante", "Continente L", "Continente V", "Goles L", "Goles V"};
        JTable table = new JTable(resultados, columnNames);
        table.setRowHeight(30);

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(4, 1, 0, 0));

        JLabel label = new JLabel();
        label.setText("Busqueda de Resultados");
        form.add(label);

        JTextField field = new JTextField();
        form.add(field);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 30, 0));

        JButton buscar = new JButton();
        buscar.setText("Buscar");
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String valorBusqueda = field.getText();
                filtrarResultados(valorBusqueda);
            }
        });
        panelBotones.add(buscar);

        JButton limpiar = new JButton();
        limpiar.setText("Ver Todos");
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pintarTablaResultados();
            }
        });
        panelBotones.add(limpiar);
        form.add(panelBotones);

        JPanel seleccionesPanel = new JPanel();
        seleccionesPanel.setLayout(new BoxLayout(seleccionesPanel, BoxLayout.Y_AXIS));
        seleccionesPanel.setPreferredSize((new java.awt.Dimension(910, 600)));
        seleccionesPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        seleccionesPanel.add(form);
        seleccionesPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(seleccionesPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    /**
     * Función que permite darle estilos y agregar los componentes gráficos del
     * contendor de la parte derecha de la interfaz, dónde se visulaiza de
     * manera dinámica el contenido de cada una de las funciones que puede
     * realizar el usuario sobre la aplicación.
     */
    private void pintarPanelDerecho() {

        // Define las dimensiones del panel
        jPanelMain.setPreferredSize((new java.awt.Dimension(1105, 460)));
        jPanelMain.setMaximumSize(jPanelLabelTop.getPreferredSize());

        getContentPane().add(jPanelRight, java.awt.BorderLayout.CENTER);
        jPanelRight.setLayout(new FlowLayout(FlowLayout.CENTER, 900, 0));
        jPanelRight.add(jPanelLabelTop, BorderLayout.LINE_START);
        jPanelRight.add(jPanelMain);
        jPanelRight.setPreferredSize((new java.awt.Dimension(920, 550)));
        jPanelRight.setMaximumSize(jPanelRight.getPreferredSize());
    }

    /**
     * Función que permite pinta la barra azul del contenedor de contenidos.
     * Barra azul que permite indicar en que sección que se encuentra navegando
     * el usuario.
     */
    private void pintarLabelTop() {
        jLabelTop = new JLabel();
        //Modifica el tamaño de la letra   
        jLabelTop.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        //Modifica el color de la letra  
        jLabelTop.setForeground(new java.awt.Color(241, 241, 241));
        jLabelTop.setText("Home");

        JLabel vacioTopLabel = new JLabel();
        //Posiciona el texto "home" justificado a la izquierda  
        jPanelLabelTop.setLayout(new BorderLayout(50, 0));
        //Separa el texto del borde y lo justifica con los demas titulos debajo de el 
        jPanelLabelTop.add(vacioTopLabel, BorderLayout.WEST);
        jPanelLabelTop.setBackground(new java.awt.Color(18, 119, 217));
        jPanelLabelTop.add(jLabelTop, BorderLayout.CENTER);
        //ancho y alto del cajon azul de home
        jPanelLabelTop.setPreferredSize((new java.awt.Dimension(910, 85)));
        jPanelLabelTop.setMaximumSize(jPanelLabelTop.getPreferredSize());
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIManual().setVisible(true);
            }
        });
    }
}
