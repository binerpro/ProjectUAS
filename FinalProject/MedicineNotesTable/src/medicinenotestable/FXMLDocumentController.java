/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicinenotestable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author mursy
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private TableView<obat> table_obat;

    @FXML
    private TableColumn<obat, Integer> col_id;

    @FXML
    private TableColumn<obat, String> col_nama;

    @FXML
    private TableColumn<obat, String> col_kategori;

    @FXML
    private TableColumn<obat, String> col_kegunaan;
    
    @FXML
    private TextField txt_nama;

    @FXML
    private TextField txt_kategori;

    @FXML
    private TextField txt_kegunaan;
    
    @FXML
    private TextField txt_id;
    
    @FXML
    private TextField filterField;
    
    ObservableList<obat> listM;
    ObservableList<obat> dataList;
    
    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    public void Add_users(){
        
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into obat (nama,kategori,kegunaan)values(?,?,?)";
        try {
            pst = conn.prepareStatement (sql);
            pst.setString(1, txt_nama.getText());
            pst.setString(2, txt_kategori.getText());
            pst.setString(3, txt_kegunaan.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Obat Add Success");
            UpdateTable();
            search_obat();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Select obat//
    @FXML
    void getSelected (MouseEvent event){
        index = table_obat.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_nama.setText(col_nama.getCellData(index).toString());
        txt_kategori.setText(col_kategori.getCellData(index).toString());
        txt_kegunaan.setText(col_kegunaan.getCellData(index).toString());
    }
    
    public void Edit(){
        try {
            conn = mysqlconnect.ConnectDb();
            String value1 = txt_id.getText();
            String value2 = txt_nama.getText();
            String value3 = txt_kategori.getText();
            String value4 = txt_kegunaan.getText();
            
            String sql = "update obat set meds_id= '"+value1+"',nama= '"+value2+"',kategori= '"+
                    value3+"',kegunaan= '"+value4+"' where meds_id='"+value1+"' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            search_obat();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    public void Delete(){
        conn = mysqlconnect.ConnectDb();
        String sql = "delete from obat where meds_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
            search_obat();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<obat,Integer>("id"));
        col_nama.setCellValueFactory(new PropertyValueFactory<obat,String>("nama"));
        col_kategori.setCellValueFactory(new PropertyValueFactory<obat,String>("kategori"));
        col_kegunaan.setCellValueFactory(new PropertyValueFactory<obat,String>("kegunaan"));
        
        listM = mysqlconnect.getDataobat();
        table_obat.setItems(listM);
        
    }
    
    @FXML
    void search_obat() {          
        col_id.setCellValueFactory(new PropertyValueFactory<obat,Integer>("id"));
        col_nama.setCellValueFactory(new PropertyValueFactory<obat,String>("nama"));
        col_kategori.setCellValueFactory(new PropertyValueFactory<obat,String>("kategori"));
        col_kegunaan.setCellValueFactory(new PropertyValueFactory<obat,String>("kegunaan"));
        
        
        dataList = mysqlconnect.getDataobat();
        table_obat.setItems(dataList);
        FilteredList<obat> filteredData = new FilteredList<>(dataList, b -> true);  
 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getNama().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Search nama obat
    } 
    else if (String.valueOf(person.getKegunaan()).indexOf(lowerCaseFilter)!=-1)
         return true;// Search Manfaat obat
                                
         else  
          return false; // tidak ditemukan
   });
  });  
  SortedList<obat> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_obat.comparatorProperty());  
  table_obat.setItems(sortedData);      
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        search_obat();
                
    }    
    
}
