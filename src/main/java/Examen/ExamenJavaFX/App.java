package Examen.ExamenJavaFX;

import java.sql.Connection;
import java.util.ArrayList;

import Examen.ExamenJavaFX.Models.AvestruzDAO;
import Examen.ExamenJavaFX.Models.AvestruzDO;
import Examen.ExamenJavaFX.Models.KoalaDAO;
import Examen.ExamenJavaFX.Models.KoalaDO;
import Examen.ExamenJavaFX.utils.UtilsBD;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
    	//******************[CONEXIÓN]******************
		Connection con = UtilsBD.conectarBD();
		
		//******************[PANELES]******************
		BorderPane bdpDistribucion = new BorderPane();
		VBox panelContenedor = new VBox();
		GridPane panelKoalas = new GridPane();
		TabPane tabPane = new TabPane();
		GridPane panelChoiceBox = new GridPane();
		ScrollPane slpScroll = new ScrollPane();
		
		//******************[PESTAÑAS]******************
		Tab tab1 = new Tab("Lista de Koalas");
		tab1.setClosable(false);
		Tab tab2 = new Tab("Koala");
		
		//******************[BARRA DE MENÚ]******************
		MenuBar barraMenu = new MenuBar();

		Menu mArchivo = new Menu("Archivo");
		
		MenuItem iCargar = new MenuItem("Cargar");
		MenuItem iSalir = new MenuItem("Salir");
		
		Menu mAvestruces = new Menu("Avestruces");
		MenuItem iEliminarAvestruz = new MenuItem("Eliminar");
		MenuItem iCargarAvestruz = new MenuItem("Cargar");
		
		Menu mKoalas = new Menu("Koalas");
		MenuItem iMostrarDatos = new MenuItem("Mostrar datos");
		
		//******************[NODOS]******************
		Label lblAvestruz = new Label("Avestruz");
		
		panelChoiceBox.setMargin(lblAvestruz, new Insets(10, 20, 10, 20));
		
		ChoiceBox<String> chbAvestruces = new ChoiceBox<>();
		chbAvestruces.setMinWidth(100);
		
		//******************[EVENTOS]******************
		ArrayList<AvestruzDO> listaAvestruces = AvestruzDAO.getAvestruz(con);
		iCargar.setOnAction(e -> {
			cargarChoiceBoxAvestruces(chbAvestruces ,listaAvestruces);
		});
		
		//Evento que se ejecuta cuando se selecciona un avestruz en el ChoiceBox de avestruces
		chbAvestruces.setOnAction(e -> {
			//Añadimos la pestaña
			tabPane.getTabs().addAll(tab1);
			//Limpiamos la pestaña 
			panelKoalas.getChildren().clear();
			
			//Comprobamos que haya algo seleccionado
			if (chbAvestruces.getSelectionModel().getSelectedIndex() != -1) {
				//Cargamos los koalas asociados a un avestruz en un array
				ArrayList<KoalaDO> listaKoalas = AvestruzDAO.cargarLacayos(
						listaAvestruces.get(chbAvestruces.getSelectionModel().getSelectedIndex()).getIdAvestruz(), con);
				//LABELS TIPO TABLA
				Label CampoID = new Label("ID |");
				panelKoalas.add(CampoID, 0, 0);
				Label CampoNombre = new Label("NOMBRE |");
				panelKoalas.add(CampoNombre, 1, 0);
				Label CampoNickguerra = new Label("NICK DE GUERRA |");
				panelKoalas.add(CampoNickguerra, 2, 0);
				Label CampoEdad = new Label(" EDAD |");

				panelKoalas.add(CampoEdad, 3, 0);
				Label CampoColor = new Label("COLOR |");

				panelKoalas.add(CampoColor, 4, 0);
				Label CampoFuerza = new Label("FUERZA |");

				panelKoalas.add(CampoFuerza, 5, 0);
				Label CampoInteligencia = new Label("INTELIGENCIA |");

				panelKoalas.add(CampoInteligencia, 6, 0);
				Label CampoTiempoSueno = new Label("TIEMPO DE SUEÑO |");

				panelKoalas.add(CampoTiempoSueno, 7, 0);
				Label CampoTiempoBerserk = new Label("TIEMPO BERSERK |");

				panelKoalas.add(CampoTiempoBerserk, 8, 0);
				
				Label CampoSeparador = new Label("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				panelKoalas.add(CampoSeparador, 0, 1, 11, 1);
				
				panelKoalas.setMargin(CampoID, new Insets(10, 20, 10, 20));
				panelKoalas.setMargin(CampoNombre, new Insets(10, 20, 10, 20));
				
				int x = 2;
				//Añadimos los koalas al panel
				for (int i = 0; i < listaKoalas.size(); i++) {
					
					int z = 0;
					Label idKoala = new Label(Integer.toString(listaKoalas.get(i).getIdKoala()));
					panelKoalas.add(idKoala, z, x);
					z++;
					Label nombre = new Label(listaKoalas.get(i).getNombre());
					panelKoalas.add(nombre, z, x);
					z++;
					Label nickguerra = new Label(listaKoalas.get(i).getNickguerra());
					panelKoalas.add(nickguerra, z, x);
					z++;
					Label edad = new Label(Integer.toString(listaKoalas.get(i).getEdad()));
					panelKoalas.add(edad, z, x);
					z++;
					Label color = new Label(listaKoalas.get(i).getColor());
					panelKoalas.add(color, z, x);
					z++;
					Label fuerza = new Label(Integer.toString(listaKoalas.get(i).getFuerza()));
					panelKoalas.add(fuerza, z, x);
					z++;
					Label inteligencia = new Label(Integer.toString(listaKoalas.get(i).getInteligencia()));
					panelKoalas.add(inteligencia, z, x);
					z++;
					Label tiempoSueno = new Label(Integer.toString(listaKoalas.get(i).getHorasSueno()));
					panelKoalas.add(tiempoSueno, z, x);
					z++;
					Label tiempoBerserk = new Label(Integer.toString(listaKoalas.get(i).getTiempoBerserk()));
					panelKoalas.add(tiempoBerserk, z, x);
					z++;
					z++;
					Button btnEditar = new Button("Editar");
					panelKoalas.add(btnEditar, z, x);
					Label separador = new Label("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					x++;
					panelKoalas.add(separador, 0, x, 11, 1);
					x++;
					
					//Array para poder llevar el valor de i al evento
					int[] arrayPosicion = { i };
					
					//Evento que se activa al pulsar en un botón editar
					btnEditar.setOnAction(eEditar -> {
						//Agregamos la segunda pestaña
						tabPane.getTabs().add(tab2);
						
						//Labels para el formulario
						Label formIdKoala = new Label("ID: ");

						Label formNombre = new Label("NOMBRE: ");

						Label formNickguerra = new Label("NICK DE GUERRA: ");

						Label formEdad = new Label(" EDAD: ");

						Label formColor = new Label("COLOR: ");

						Label formFuerza = new Label("FUERZA: ");

						Label formInteligencia = new Label("INTELIGENCIA: ");

						Label formTiempoSueno = new Label("TIEMPO DE SUEÑO: ");

						Label formTiempoBerserk = new Label("TIEMPO BERSERK: ");
						
						GridPane panelKoalaTab2 = new GridPane();
						
						//Textfields del formulario
						TextField txtIdKoala = new TextField();
						txtIdKoala.setText(Integer.toString(listaKoalas.get(arrayPosicion[0]).getIdKoala()));
						
						TextField txtNombre = new TextField();
						txtNombre.setText(listaKoalas.get(arrayPosicion[0]).getNombre());

						TextField txtNickguerra = new TextField();
						txtNickguerra.setText(listaKoalas.get(arrayPosicion[0]).getNickguerra());

						TextField txtEdad = new TextField();
						txtEdad.setText(Integer.toString(listaKoalas.get(arrayPosicion[0]).getEdad()));

						TextField txtColor = new TextField();
						txtColor.setText(listaKoalas.get(arrayPosicion[0]).getColor());
						
						TextField txtFuerza = new TextField();
						txtFuerza.setText(Integer.toString(listaKoalas.get(arrayPosicion[0]).getFuerza()));
						
						TextField txtInteligencia = new TextField();
						txtInteligencia.setText(Integer.toString(listaKoalas.get(arrayPosicion[0]).getInteligencia()));
						
						TextField txtTiempoSueno = new TextField();
						txtTiempoSueno.setText(Integer.toString(listaKoalas.get(arrayPosicion[0]).getHorasSueno()));
						
						TextField txtTiempoBerserk = new TextField();
						txtTiempoBerserk.setText(Integer.toString(listaKoalas.get(arrayPosicion[0]).getTiempoBerserk()));
						
						//Lo añadimos al panel
						panelKoalaTab2.add(formIdKoala, 0, 0);
						panelKoalaTab2.add(txtIdKoala, 1, 0);
						panelKoalaTab2.add(formNombre, 0, 1);
						panelKoalaTab2.add(txtNombre, 1, 1);
						panelKoalaTab2.add(formNickguerra, 0, 2);
						panelKoalaTab2.add(txtNickguerra, 1, 2);
						panelKoalaTab2.add(formEdad, 0, 3);
						panelKoalaTab2.add(txtEdad, 1, 3);
						panelKoalaTab2.add(formColor, 0, 4);
						panelKoalaTab2.add(txtColor, 1, 4);
						panelKoalaTab2.add(formFuerza, 0, 5);
						panelKoalaTab2.add(txtFuerza, 1, 5);
						panelKoalaTab2.add(formInteligencia, 0, 6);
						panelKoalaTab2.add(txtInteligencia, 1, 6);
						panelKoalaTab2.add(formTiempoSueno, 0, 7);
						panelKoalaTab2.add(txtTiempoSueno, 1, 7);
						panelKoalaTab2.add(formTiempoBerserk, 0, 8);
						panelKoalaTab2.add(txtTiempoBerserk, 1, 8);
						
						//panelKoalaTab2.getChildren().addAll(txtIdKoala, txtNombre, txtNickguerra, txtEdad, txtColor, txtFuerza, txtInteligencia, txtTiempoSueno, txtTiempoBerserk);
						
						tab2.setContent(panelKoalaTab2);
					});
					
					//Margenes
					panelKoalas.setMargin(idKoala, new Insets(10, 20, 10, 20));
					panelKoalas.setMargin(nombre, new Insets(10, 20, 10, 20));
					panelKoalas.setMargin(nickguerra, new Insets(10, 20, 10, 20));
					panelKoalas.setMargin(edad, new Insets(10, 20, 10, 20));
					panelKoalas.setMargin(color, new Insets(10, 20, 10, 20));
					panelKoalas.setMargin(fuerza, new Insets(10, 20, 10, 20));
					panelKoalas.setMargin(inteligencia, new Insets(10, 20, 10, 20));
					panelKoalas.setMargin(tiempoSueno, new Insets(10, 20, 10, 20));
					panelKoalas.setMargin(tiempoBerserk, new Insets(10, 20, 10, 20));
				}
				
				
			}
			
		});
		
		//Evento que cierra la aplicación al pulsar en Salir
		iSalir.setOnAction(e -> {
			stage.close();
		});
		
		//Evento que se activa al darle a Mostar datos
		iMostrarDatos.setOnAction(e -> {
			//Creamos una nueva ventana
			Stage ventanaEmergente = new Stage();
			ventanaEmergente.setResizable(false);
			
			//Paneles
			VBox panelKoalaEmergente = new VBox();
			VBox panelContenidoKoala = new VBox();
			
			//Lista con todos los koalas
			ArrayList<KoalaDO> listaKoalas = KoalaDAO.getKoala(con);
			
			//Nodos
			ChoiceBox<String> chbKoalas = new ChoiceBox<>();
			Button btnCargarDatosKoala = new Button("Cargar");
			
			panelKoalaEmergente.setMargin(chbKoalas, new Insets(10, 20, 10, 20));
			panelKoalaEmergente.setMargin(btnCargarDatosKoala, new Insets(10, 20, 10, 20));
			
			//Bucle que inserta los koalas al ChoiceBox
			for (int i = 0; i < listaKoalas.size(); i++) {
				chbKoalas.getItems().add(Integer.toString(listaKoalas.get(i).getIdKoala()));
								
				//evento que se activa al seleccionar un koala
				chbKoalas.setOnAction(ekoalas -> {
					//Me crea un objeto KoalaDO con los datos del seleccionado
					KoalaDO koala = KoalaDAO.cargarKoala(con, listaKoalas.get( chbKoalas.getSelectionModel().getSelectedIndex()).getIdKoala());
				
					//Evento que se activa al darle a Cargar datos
					btnCargarDatosKoala.setOnAction(eCargar -> {
						//Metemos los datos del koala seleccionado
						panelContenidoKoala.getChildren().clear();
						Label lblNombre = new Label("Nombre: " + koala.getNombre());
						Label lblNickguerra = new Label("Nickguerra: " + koala.getNickguerra());
						Label lblEdad = new Label("Edad: " + Integer.toString(koala.getEdad()));
						Label lblColor = new Label("Color: " + koala.getColor());
						Label lblFuerza = new Label("Fuerza: " + Integer.toString(koala.getFuerza()));
						Label lblInteligencia = new Label("Inteligencia: " + Integer.toString(koala.getInteligencia()));
						Label lblHorasSueno = new Label("Horas de Sueño" + Integer.toString(koala.getHorasSueno()));
						Label lblTiempoBerserk = new Label("Tiempo Berserk: " + Integer.toString(koala.getTiempoBerserk()));
						panelContenidoKoala.getChildren().addAll(lblNombre, lblNickguerra, lblEdad, lblColor, lblFuerza, lblInteligencia, lblHorasSueno, lblTiempoBerserk);
						
						panelContenidoKoala.setMargin(lblNombre, new Insets(10, 20, 0, 20));
						panelContenidoKoala.setMargin(lblNickguerra, new Insets(10, 20, 0, 20));
						panelContenidoKoala.setMargin(lblEdad, new Insets(10, 20, 0, 20));
						panelContenidoKoala.setMargin(lblColor, new Insets(10, 20, 0, 20));
						panelContenidoKoala.setMargin(lblFuerza, new Insets(10, 20, 0, 20));
						panelContenidoKoala.setMargin(lblInteligencia, new Insets(10, 20, 0, 20));
						panelContenidoKoala.setMargin(lblHorasSueno, new Insets(10, 20, 0, 20));
						panelContenidoKoala.setMargin(lblTiempoBerserk, new Insets(10, 20, 0, 20));
					});
				});
				
				
			}
			
			
			//Añadimos todo al panel principal de la ventana emergente
			panelKoalaEmergente.getChildren().addAll(chbKoalas, btnCargarDatosKoala, panelContenidoKoala);
			
			Scene escenaEmerg = new Scene(panelKoalaEmergente, 400, 400);
			ventanaEmergente.setScene(escenaEmerg);
			ventanaEmergente.setTitle("Datos de Koalas");
			ventanaEmergente.show();
		});
		
		//Evento que se activa al darle a eliminar
		iEliminarAvestruz.setOnAction(e -> {
			//Comprueba que hay un avestruz seleccionado
			if(chbAvestruces.getSelectionModel().getSelectedIndex() != -1) {
				//Lo elimina de la base de datos
				AvestruzDAO.eliminar(listaAvestruces.get(chbAvestruces.getSelectionModel().getSelectedIndex()).getIdAvestruz(), con);
				//Lo elimina del ArrayList
				listaAvestruces.remove(chbAvestruces.getSelectionModel().getSelectedIndex());
				//Carga de nuevo el ChoiceBox
				cargarChoiceBoxAvestruces(chbAvestruces ,listaAvestruces);
			}
		});
		
		
		//******************[ADICIÓN DE ELEMENTOS]******************
		
		barraMenu.getMenus().addAll(mArchivo, mKoalas, mAvestruces);
		mArchivo.getItems().addAll(iCargar, iSalir);
		mAvestruces.getItems().addAll(iEliminarAvestruz, iCargarAvestruz);
		mKoalas.getItems().addAll(iMostrarDatos);
		
		panelChoiceBox.add(lblAvestruz, 0, 0);
		panelChoiceBox.add(chbAvestruces, 1, 0);
		
		panelContenedor.getChildren().addAll(panelChoiceBox, tabPane);
		
		bdpDistribucion.setTop(barraMenu);
		bdpDistribucion.setCenter(panelContenedor);
		
		slpScroll.setContent(panelKoalas);
		
		tab1.setContent(slpScroll);
		
		Scene scene = new Scene(bdpDistribucion, 900, 600);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Examen de Jairo Cereceda Berciano");
		stage.show();
    }
    
    /**
     * Función que carga las avestruces en el choiceBox
     * @param chbAvestruces
     * @param listaAvestruces
     */
    public static void cargarChoiceBoxAvestruces(ChoiceBox chbAvestruces, ArrayList<AvestruzDO> listaAvestruces) {
    	//Elimina los items del choiceBox
    	chbAvestruces.getItems().clear();

    	//introduce los items en el choiceBox desde el arraylist
		for (int i = 0; i < listaAvestruces.size(); i++) {
			chbAvestruces.getItems().add(listaAvestruces.get(i).getNombre());
		}
    }

    public static void main(String[] args) {
        launch();
    }

}