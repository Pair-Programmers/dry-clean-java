/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc;

import DataBaseConnectivity.DataBaseConnection;
import Interface.DressAndServicePrice;
import Interface.DressAndServicePriceArrayList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mian Hamza Saqib
 */
public class DressesAndServicesPriceController implements Initializable {

    DressAndServicePriceArrayList dressAndServicePriceArrayList = new DressAndServicePriceArrayList();
    
    @FXML
    private ComboBox<String> dressComboBox;

    @FXML
    private ComboBox<String> ServiceComboBox;

    @FXML
    private Button addButton;

    @FXML
    private Button closeButton;

    @FXML
    private Button updateButton;
    
    @FXML
    private TextField priceTextField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] dressArray = {"Shalwar kameez","Sherwani","Pent Coat","Coat","Jeans","Dress Shirt","T-Shirt","Jacket","Waistcoat","Lehnga/Sardhi","Women Suite","Curtain","Blanket","Bed Sheet","Under Garments"};
        dressComboBox.getItems().add("Select");
        for(int i = 0; i < 15; i++){
            dressComboBox.getItems().add(dressArray[i]);
        }
        //dressComboBox.getItems().set(0,"Select");
        
        ServiceComboBox.getItems().add("Select");
        ServiceComboBox.getItems().add("Wash and Press");
        ServiceComboBox.getItems().add("Wash Only");
        ServiceComboBox.getItems().add("Press Only");
        
    }    
    

    @FXML
    void addButtonActionListner(ActionEvent event) {
        DressAndServicePrice tempObj;
        //System.out.println(dressAndServicePriceArrayList.getList().size());
        try {
            if(dressComboBox.getValue().equals("Select") || ServiceComboBox.getValue().equals("Select") || priceTextField.getText().equals("")) {
                System.out.println("Select Dress and Service or enter price");
            } else {
                tempObj = new DressAndServicePrice(dressComboBox.getValue(),ServiceComboBox.getValue(),Integer.parseInt(priceTextField.getText())); 
                if(dressAndServicePriceArrayList.getList().size() == 0) {
                    System.out.println("2");
                    dressAndServicePriceArrayList.addDressAndServicePrivce(tempObj);
                } else {
                    System.out.println("3");
                    int i = 0;
                    boolean flag = false;
                    while(i < dressAndServicePriceArrayList.getList().size()){
                        System.out.println(dressAndServicePriceArrayList.getList().get(i).getDress());
                        System.out.println(tempObj.getDress());
                        if(dressAndServicePriceArrayList.getList().get(i).getDress()==tempObj.getDress() && dressAndServicePriceArrayList.getList().get(i).getService() == tempObj.getService()){
                            System.out.println("alraedy added");
                            flag = true;
                            break;
                        }
                        i++;
                        System.out.println("loop" + i);
                    }    
                    if(!flag) {
                        dressAndServicePriceArrayList.addDressAndServicePrivce(tempObj);
                        System.out.println("addedd");
                    }
                }
                

            }
        } catch (Exception e) {
            System.out.println("Select Dress and Service or enter price");
        }
        
    }

    @FXML
    void closeButtonActionListner(ActionEvent event) {
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void updateButtonActionListner(ActionEvent event) {
        //String[] dressArray = {"Shalwar kameez","Sherwani","Pent Coat","Coat","Jeans","Dress Shirt","T-Shirt","Jacket","Waistcoat","Lehnga/Sardhi","Women Suite","Curtain","Blanket","Bed Sheet","Under Garments"};
        if(dressAndServicePriceArrayList.getList().size()>0) {
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            dataBaseConnection.connectDataBase();
            int i = 0;
            while(i < dressAndServicePriceArrayList.getList().size()){
                DressAndServicePrice tempObj = dressAndServicePriceArrayList.getList().get(i);
                String query = "UPDATE `dressandservice` SET price = "+tempObj.getPrice()+" WHERE dressID = (select id from dresses WHERE dName = '"+tempObj.getDress()+"') AND serviceID = (select id from services WHERE sName = '"+tempObj.getService()+"')";//dressAndServicePriceArrayList.getList().get(i).
                dataBaseConnection.runExecuteUpdate(query);
                i++;
            }
            JOptionPane.showMessageDialog(null, "Updated Sucessfully, Closed this Software and Restart !");
            
        } else {
            JOptionPane.showMessageDialog(null, "Please add prices firt ... !");
        }
        
        
    }


}
