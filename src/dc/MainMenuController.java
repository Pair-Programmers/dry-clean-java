/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc;

import DataBaseConnectivity.DataBaseConnection;

import Interface.Customer;
import Interface.CustomerArrayList;
import Interface.DressAndServicePrice;
import Interface.DressAndServicePriceArrayList;
import Interface.Order;
import Interface.OrderArrayList;
import Interface.OrderInfo;
import Interface.OrderInfoArrayList;
import Interface.OrderTableListForClean;
import Interface.OrderTableListForDelivered;
import Interface.PrinterService;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.apache.commons.lang.text.StrBuilder;

/**
 * FXML Controller class
 *
 * @author Mian Hamza Saqib
 */
public class MainMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
            
    private String printerName;
    private Order newOrder = new Order();
    private OrderInfo orderInfo = new OrderInfo();
    private OrderInfoArrayList orderInfoArrayList = new OrderInfoArrayList();
    private OrderArrayList orderArrayList = new OrderArrayList();
    private Customer customer = new Customer();
    private String loundaryButtonsDetector = "";
    private int orderInfoIdCounter = 1;
    private int OrderNumberCounter = 0;
    private int OrderNumber;
    private boolean isCustomerSearched;
    private boolean isDateSlectedFromPicker = false;
    private boolean isTimeFromComboBox = false;
    ObservableList<OrderInfo> orderInfoTableList;
    ObservableList<OrderTableListForClean> orderCleanTableList;
    ObservableList<OrderTableListForDelivered> orderDeliveredTableList;
    private int orderThatRemoveFromReadyList;
    private boolean isOrderThatRemoveFromReadyListCashRecieved = false;
    private DressAndServicePriceArrayList dressAndServicePriceArrayList = new DressAndServicePriceArrayList();
    @FXML
    private Pane orderClaenReadyButtonsPane;
    @FXML
    private ToggleGroup washClean;
    @FXML
    private Button newOrderButton;

    @FXML
    private Button cleanButton;

    @FXML
    private Button readyButton;

    @FXML
    private Pane mainPane;

    @FXML
    private Group newOrderGroup;

    @FXML
    private Button addCustomer;

    @FXML
    private ToggleGroup paymentMethod;

    @FXML
    private Label orderNumberLabelG1;
    
    @FXML
    private Label totalWithDiscount;
    
    @FXML
    private Label totalBeneathTableLabel;
    
    @FXML
    private Label totalPriceG15Label;
    
    @FXML
    private Label changeLabel;
    
    @FXML
    private Label discountG15Label;
    @FXML
    private Label totalWithDiscountLabel;
    
    @FXML
    private Label customerLabelG1;
    @FXML
    private Label customerSearchOrdersLabel;

    @FXML
    private Pane loandryCustomerInfoPane;

    @FXML
    private Group loandaryButtonsGroup;

    @FXML
    private Button shalwarKameezButton;

    @FXML
    private Button sherwaniButton;

    @FXML
    private Button dressShirtButton;

    @FXML
    private Button tShirtButton;

    @FXML
    private Button womenSuiteButton;

    @FXML
    private Button jacketButton;

    @FXML
    private Button pentCoatButton;

    @FXML
    private Button curtainButoon;

    @FXML
    private Button blanketButton;

    @FXML
    private Button jeansButton;

    @FXML
    private Button coatButton;

    @FXML
    private Button longCoatButton;

    @FXML
    private Button lehngaButton;

    @FXML
    private Button bedsheetButton;

    @FXML
    private Button underGarmentsButton;

    @FXML
    private Group addCustomerGroup;

    @FXML
    private TextField orderNumberTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField adressTextField;

    @FXML
    private TextField addQtyTextField;
    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField discountTextField;

    @FXML
    private TextField searchOrderNumberTextField;
    
    @FXML
    private TextField notesTextField;

    @FXML
    private TextField discountG15TextField;
    
    @FXML
    private TextField cashRecieved2TextField1;

    @FXML
    private TextField searchDTextField;
    @FXML
    private TextField discountG152TextField1;
    
    @FXML
    private TextField phoneShowCustomerTextField;
    @FXML
    private TextField cashRecievedTextField;
    @FXML
    private Button doneButton;

    @FXML
    private Group loandaryButtonsInfoGroup;

    @FXML
    private Group searchCustomerGroup;
    
    @FXML
    private Group generatSlipGroup;
    @FXML
    private Button redButton;

    @FXML
    private Button greenButton;

    @FXML
    private Button whiteButton;

    @FXML
    private Button blueButton;

    @FXML
    private Button pinkButton;

    @FXML
    private Button purpleButton;

    @FXML
    private Button greyButton;

    @FXML
    private Button creamButton;

    @FXML
    private Button blackButton;

    @FXML
    private Button brownButton;
    @FXML
    private Button okcashRecievedButton;
    @FXML
    private Button buttonBrokenButton;

    @FXML
    private Button oilButton;

    @FXML
    private Button ironMarkButton;

    @FXML
    private Button teaButton;

    @FXML
    private Button bloodButton;

    @FXML
    private Button greaseButton;

    @FXML
    private Button mudButton;

    @FXML
    private Button holesButton;
    
    @FXML
    private Button printAndSaveButton;

    @FXML
    private Button foodButton;

    @FXML
    private Button paintButton;

    @FXML
    private Button searchButton;
    
    @FXML
    private Label issuesLabel;
    
    @FXML
    private Label nameShowCustomerLabel;
    @FXML
    private Label adressShowCustomerLabel;
    @FXML
    private Label noteShowCustomerLabel;
    @FXML
    private Label discountShowCustomerLabel;

    @FXML
    private Label noOfPaidLabel;
    @FXML
    private Label amountPaidLabel;
    @FXML
    private Label noOfUnPaidLabel;
    @FXML
    private Label amountUnPaidLabel;
    
    
    
    @FXML
    private Label recievedDLabel;
    @FXML
    private Label discountDLabel;
    @FXML
    private Label totalPriceDLabel;
    @FXML
    private Label totalNumberrrrrDLabel;
    
    @FXML
    private Label totalPriceG152Label1;
    @FXML
    private Label totalWithDiscount2;
    @FXML
    private Label change2Label1;
    
    @FXML
    private Button issuesClearButton;

    @FXML
    private MenuItem mainMenuBar;
    

    @FXML
    private DatePicker readyByDatePicker;

    @FXML
    private ComboBox<String> timeComboBox;

    @FXML
    private ToggleGroup AmPm;

    @FXML
    private Button doneG3Button;
    
    @FXML
    private Button searchOrderNumberButton;
    @FXML
    private Button cleanedCollectedButton;

    @FXML
    private Group cleanGroup;

    @FXML
    private Group readyListGroup;

    @FXML
    private Group raedyListSubListGroup;

    @FXML
    private Group readyGroup;
    
    @FXML
    private Group recievingCashGroup;

    @FXML
    private Group cleanListGroup;

    @FXML
    private Group cleanListSubListGroup;

    @FXML
    private Group deliveredGroup;

    @FXML
    private TableView<OrderInfo> orderInfoTableView;

    @FXML
    private TableView<OrderTableListForClean> orderCTableView;
    
    @FXML
    private TableView<OrderTableListForDelivered> orderDTableView;
    
    @FXML
    private TableColumn<OrderInfo, Integer> noColumOrderInfo;

    @FXML
    private TableColumn<OrderInfo, String> dressesColumOrderInfo;
    @FXML
    private TableColumn<OrderInfo, Integer> qtyColumOrderInfo;
    @FXML
    private TableColumn<OrderInfo, String> serviceColumOrderInfo;
    
    @FXML
    private TableColumn<OrderInfo, Integer> priceColumOrderInfo;
    @FXML
    private TableColumn<OrderInfo, Integer> totalPriceColumOrderInfo;

    

    
    
    ///////////////////////////////////clear tabel
    @FXML
    private TableColumn<OrderTableListForClean, Integer> orderNoCTableColumn;

    @FXML
    private TableColumn<OrderTableListForClean, String> itemTableColumn;
    
    @FXML
    private TableColumn<OrderTableListForClean, String> customerCTableColumn;

    @FXML
    private TableColumn<OrderTableListForClean, String> phoneCTableColumn;
    

    @FXML
    private TableColumn<OrderTableListForClean, Integer> dressesNoCTableColumn;

    @FXML
    private TableColumn<OrderTableListForClean, String> readyByCTableColumn;

    @FXML
    private TableColumn<OrderTableListForClean, String> orderDateCTableColumn;

    @FXML
    private TableColumn<OrderTableListForClean, Integer> priceCTableColumn;

    @FXML
    private TableColumn<OrderTableListForClean, String> statusCTableColumn;
    
    ///////////////////////////////////Deliver table
    @FXML
    private TableColumn<OrderTableListForDelivered, Integer> orderNumberDTableColumn;

    @FXML
    private TableColumn<OrderTableListForDelivered, String> customerDTableColumn;

    @FXML
    private TableColumn<OrderTableListForDelivered, String> phoneDTableColumn;

    @FXML
    private TableColumn<OrderTableListForDelivered, String> itemsDTableColumn;

    @FXML
    private TableColumn<OrderTableListForDelivered, Integer> pcsDTableColumn;

    @FXML
    private TableColumn<OrderTableListForDelivered, Integer> priceDTableColumn;

    @FXML
    private TableColumn<OrderTableListForDelivered, Integer> receivedDTableColumn;

    @FXML
    private TableColumn<OrderTableListForDelivered, Integer> discountDTableColumn;

    @FXML
    private TableColumn<OrderTableListForDelivered, String> orderDateDTableColumn;

    @FXML
    private TableColumn<OrderTableListForDelivered, String> deliverDateDTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("java FXNL : " + System.getProperties().get("javafx.runtime.version"));
        for(int i = 1; i < 13; i++){
            timeComboBox.getItems().add(String.valueOf(i));
        }
        printerName = "Black Copper BC-95AC";
        //initializing table  metaData
        orderInfoTableList = FXCollections.observableArrayList();
        //////////////// orderinfo table
        noColumOrderInfo.setCellValueFactory(new PropertyValueFactory<>("id"));
        dressesColumOrderInfo.setCellValueFactory(new PropertyValueFactory<>("dressName"));
        serviceColumOrderInfo.setCellValueFactory(new PropertyValueFactory<>("service"));
        priceColumOrderInfo.setCellValueFactory(new PropertyValueFactory<>("price"));
        qtyColumOrderInfo.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        totalPriceColumOrderInfo.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        orderInfoTableView.setItems(orderInfoTableList);
        
//getting dresses and services prices
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT dName, sName, `price` FROM dresses d, services s, `dressandservice` ds WHERE d.id = ds.dressID and s.id = ds.serviceID";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            while (rs.next()) {
                dressAndServicePriceArrayList.addDressAndServicePrivce(new DressAndServicePrice(rs.getString("dName"), rs.getString("sName"),rs.getInt("price")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "MySQL Server is not Runing !");
        }
        //geting last order Number
        query = "SELECT `orderNumber` FROM `order` ORDER BY orderNumber DESC LIMIT 1";
        rs = dataBaseConnection.runSelectQuery(query);
        try {
            if(rs.next()){
                OrderNumber = rs.getInt("orderNumber");
            } else {
                OrderNumber = 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Getting Last Order Number : (" + e.getMessage() + ")");
        }
        OrderNumber++;
        orderNumberLabelG1.setText(String.valueOf(OrderNumber));
        
        // for clean table group
        orderCleanTableList = FXCollections.observableArrayList();
        orderNoCTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
        customerCTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        phoneCTableColumn.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        dressesNoCTableColumn.setCellValueFactory(new PropertyValueFactory<>("noOfdresses"));
        readyByCTableColumn.setCellValueFactory(new PropertyValueFactory<>("readyBy"));
        orderDateCTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        priceCTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusCTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        itemTableColumn.setCellValueFactory(new PropertyValueFactory<>("items"));
        orderCTableView.setItems(orderCleanTableList);
        
        // for deliver table group
        orderDeliveredTableList = FXCollections.observableArrayList();
       
        orderNumberDTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
        customerDTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        phoneDTableColumn.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        pcsDTableColumn.setCellValueFactory(new PropertyValueFactory<>("noOfdresses"));
        orderDateDTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        deliverDateDTableColumn.setCellValueFactory(new PropertyValueFactory<>("deliverDate"));
        priceDTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        receivedDTableColumn.setCellValueFactory(new PropertyValueFactory<>("recieved"));
        discountDTableColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        itemsDTableColumn.setCellValueFactory(new PropertyValueFactory<>("items"));
        orderDTableView.setItems(orderDeliveredTableList);
        //OrderInfoArrayList orderInfoArrayListTemp = new OrderInfoArrayList();
        
        query = "SELECT `orderNumber`, `paymentStatus`, `orderDate`, `deliverDate`, `CName`, `Phone`, `adress`, `email`, `discount`, `note`, `cashRecieved` FROM `order` AS o, `customer` AS c WHERE o.customerPhoneNo = c.Phone";
        rs = dataBaseConnection.runSelectQuery(query);
        try {
            while(rs.next()) {
                orderArrayList.addOrder(new Order(rs.getInt("orderNumber"), rs.getString("orderDate"), rs.getString("deliverDate"), rs.getString("paymentStatus"), rs.getInt("cashRecieved"), new Customer(rs.getString("CName"),rs.getString("Phone"),rs.getString("adress"),rs.getString("email"),rs.getInt("discount"),rs.getString("note")), new OrderInfoArrayList()));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Searching Order & Customers : (" + e.getMessage() + ")");
        }
        
        for (int i = 0; i < orderArrayList.getList().size(); i++) {
            query = "SELECT `dName`, `sName`, `price`, `Issues`, `readyBy`, `time`, `workingStatus`, `qty` FROM `orderinfo` AS oi, dresses AS d, services AS s, dressandservice AS ds WHERE oi.orderNumber = "+orderArrayList.getList().get(i).getOrderNumber()+" AND oi.dressServiceID = ds.id AND ds.dressID = d.id AND ds.serviceID = s.id";
            rs = dataBaseConnection.runSelectQuery(query);
            try {
                int no=0;
                while(rs.next()){
                    
                    orderArrayList.getList().get(i).getOrderInfoArrayList().getList().add(new OrderInfo(no, rs.getString("dName"), rs.getString("sName"), rs.getInt("price"), rs.getInt("qty"), rs.getInt("price")*rs.getInt("qty"), rs.getString("readyBy"), rs.getString("time"), rs.getString("Issues"), rs.getString("workingStatus")));
                    no++;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error Searching Order Sub Information  : (" + e.getMessage() + ")");
            }
            /*orderArrayList.getList().get(i).setOrderInfoArrayList(new OrderInfoArrayList());
            for (int j = 0; j < orderInfoArrayListTemp.getList().size(); j++) {
                orderArrayList.getList().get(i).getOrderInfoArrayList().getList().add(orderInfo);
            }
            orderInfoArrayListTemp.getList().clear();*/
        }
            
    } 
    
    void cashRecievd2(){
        int total = 0;
        int cashRecieved = 0;
        float discount = 0;
        float totalWithDiscount = 0;
        float change = 0;
        try {
            total = Integer.parseInt(totalPriceG152Label1.getText());
            cashRecieved = Integer.parseInt(cashRecieved2TextField1.getText());
            //discount = Float.valueOf(discountG15TextField.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Inter Cash Recieved, Not in Points !");
        }
        totalWithDiscount = total;
        if(cashRecieved >= total) {
            if (discount > 0 && discount < 100) {
                totalWithDiscount = total - total*(discount/100);
                change = cashRecieved - totalWithDiscount;
                this.totalWithDiscount2.setText(String.valueOf((int)totalWithDiscount));
                change2Label1.setText(String.valueOf((int)change));
            } else if (discount <= 0) {
                this.totalWithDiscount2.setText(String.valueOf((int)totalWithDiscount));
                change = cashRecieved - totalWithDiscount;
                change2Label1.setText(String.valueOf((int)change));
            } else if (discount >= 100) {
                totalWithDiscount = 0;
                change = cashRecieved - totalWithDiscount;
                this.totalWithDiscount2.setText(String.valueOf((int)totalWithDiscount));
                change2Label1.setText(String.valueOf((int)change));
            } else {
                //do nothing
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Check your Cash again its less than Total price !");
        }
    }
    void discount2(){
        int total = 0;
        int cashRecieved = 0;
        float discount = 0;
        float totalWithDiscount = 0;
        float change = 0;
        try {
            total = Integer.parseInt(totalPriceG152Label1.getText());
            cashRecieved = Integer.parseInt(cashRecieved2TextField1.getText());
            discount = Float.valueOf(discountG152TextField1.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Inter Cash Recieved, Not in Points !");
        }
        totalWithDiscount = total;
        if(cashRecieved >= total) {
            if (discount > 0 && discount < 100) {
                totalWithDiscount = total - total*(discount/100);
                change = cashRecieved - totalWithDiscount;
                this.totalWithDiscount2.setText(String.valueOf((int)totalWithDiscount));
                change2Label1.setText(String.valueOf((int)change));
            } else if (discount <= 0) {
                this.totalWithDiscount2.setText(String.valueOf((int)totalWithDiscount));
                change = cashRecieved - totalWithDiscount;
                change2Label1.setText(String.valueOf((int)change));
            } else if (discount >= 100) {
                totalWithDiscount = 0;
                change = cashRecieved - totalWithDiscount;
                this.totalWithDiscount2.setText(String.valueOf((int)totalWithDiscount));
                change2Label1.setText(String.valueOf((int)change));
            } else {
                //do nothing
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Check your Cash again its less than Total price !");
        }
    }
    @FXML
    void cashRecievedOk2ButonAcionListner(ActionEvent event) {
        cashRecievd2();
    }
    
    @FXML
    void discountOk2ButonAcionListner(ActionEvent event) {
        discount2();
    }
    
    @FXML
    void cashRecieved2TextFieldActionListner(ActionEvent event) {
        cashRecievd2();
    }
    
    @FXML
    void discountG152TextFieldActionListner(ActionEvent event) {
        discount2();
    }
    @FXML
    void doneG5CashrecievButtonActionListner(ActionEvent event) {
        if(!cashRecieved2TextField1.getText().equals("")){
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            dataBaseConnection.connectDataBase();
            OrderTableListForClean orderTableListForClean = orderCTableView.getSelectionModel().getSelectedItem();
            JOptionPane.showMessageDialog(null, Integer.parseInt(totalWithDiscount2.getText()));
            String query = "UPDATE `order` SET `cashRecieved` = "+Integer.parseInt(totalWithDiscount2.getText())+" WHERE `orderNumber` = "+orderTableListForClean.getOrderNumber()+"";
            dataBaseConnection.runExecuteUpdate(query);
            
            for (int i = 0; i < orderArrayList.getList().size(); i++) {
                if(orderArrayList.getList().get(i).getOrderNumber() == orderTableListForClean.getOrderNumber()) {
                    StringBuilder Items = new StringBuilder();
                    int noOfDresses = 0;
                    for (int j = 0; j < orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size(); j++) {
                        orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).setWorkingStatus("Collected");
                        orderArrayList.getList().get(i).setCashRecieved(Integer.parseInt(totalWithDiscount2.getText()));
                        noOfDresses = noOfDresses + orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getQuantity();
                        Items.append(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getDressName());
                        if(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size() == 1) {
                        } else {
                            Items.append(" / ");
                        }
                    }
                    orderCleanTableList.remove(orderTableListForClean);
                    JOptionPane.showMessageDialog(null, "Order is Moved to Collected List");
                    if(orderTableListForClean.getStatus().equals("Paid")) {
                        noOfPaidLabel.setText(String.valueOf(Integer.parseInt(noOfPaidLabel.getText()) - 1));
                        amountPaidLabel.setText(String.valueOf(Integer.parseInt(amountPaidLabel.getText()) - orderArrayList.getList().get(i).getTotalPrice()));
                    } else {
                        noOfUnPaidLabel.setText(String.valueOf(Integer.parseInt(noOfUnPaidLabel.getText()) - 1));
                        amountUnPaidLabel.setText(String.valueOf(Integer.parseInt(amountUnPaidLabel.getText()) - orderArrayList.getList().get(i).getTotalPrice()));
                    }
                    orderThatRemoveFromReadyList = orderTableListForClean.getOrderNumber();


                    LocalDateTime currentTime = LocalDateTime.now();
                    StringBuilder date =  new StringBuilder();
                    date.append(String.valueOf(currentTime).substring(0,4));date.append("-");
                    date.append(String.valueOf(currentTime).substring(5,7));date.append("-");
                    date.append(String.valueOf(currentTime).substring(8,10));
                    orderArrayList.getList().get(i).setDeliverdate(date.toString());
                    
                    query = "UPDATE `order` SET deliverDate = '"+date.toString()+"' WHERE `orderNumber` = "+orderTableListForClean.getOrderNumber()+"";
                    dataBaseConnection.runExecuteUpdate(query);
                    JOptionPane.showMessageDialog(null, "aefsdgsdsdgsdgsdgsdgsd !");
                    orderDeliveredTableList.add(new OrderTableListForDelivered(orderArrayList.getList().get(i).getOrderNumber(), orderArrayList.getList().get(i).getCustomer().getName(), orderArrayList.getList().get(i).getCustomer().getPhone(), Items.toString(), noOfDresses, orderArrayList.getList().get(i).getTotalPrice(),Integer.parseInt(totalWithDiscount2.getText()), orderArrayList.getList().get(i).getTotalPrice()-Integer.parseInt(totalWithDiscount2.getText()), orderArrayList.getList().get(i).getOrderDate(),date.toString()));
            
                    break;
                }
                mainPane.getChildren().clear();
                mainPane.getChildren().add(cleanGroup);
                cleanGroup.setVisible(true);
            }
            totalPriceG152Label1.setText("0");
            cashRecieved2TextField1.setText("");
            discountG152TextField1.setText("");
            totalWithDiscount2.setText("0");
            change2Label1.setText("0");
            recievingCashGroup.setVisible(false);
            isOrderThatRemoveFromReadyListCashRecieved = true;
        } else {
            JOptionPane.showMessageDialog(null, "Please Recieve Cash Firts !");
        }
    }
    
    @FXML
    void cancelG5CashrecievButtonActionListner(ActionEvent event) {
        totalPriceG152Label1.setText("0");
        cashRecieved2TextField1.setText("");
        discountG152TextField1.setText("");
        totalWithDiscount2.setText("0");
        change2Label1.setText("0");
        recievingCashGroup.setVisible(false);
        cleanGroup.setVisible(true);
        isOrderThatRemoveFromReadyListCashRecieved = false;
        
    }
    
    
    
    
    void commonForSearchOrderNumberActionListnerButtonAndTextField(){
        int orderTemp = 0;
        boolean isOrderNumberFound = false;
        try {
            orderTemp = Integer.parseInt(searchOrderNumberTextField.getText());
            for (int i = 0; i < orderCleanTableList.size(); i++) {
                if(orderTemp == orderCleanTableList.get(i).getOrderNumber()) {
                    OrderTableListForClean orderTableListForClean = new OrderTableListForClean(orderCleanTableList.get(i).getOrderNumber(), orderCleanTableList.get(i).getCustomerName(), orderCleanTableList.get(i).getPhone(), orderCleanTableList.get(i).getOrderDate(), orderCleanTableList.get(i).getReadyBy(), orderCleanTableList.get(i).getNoOfdresses(), orderCleanTableList.get(i).getPrice(), orderCleanTableList.get(i).getStatus(), orderCleanTableList.get(i).getItems());
                    orderCleanTableList.clear();
                    orderCleanTableList.add(orderTableListForClean);
                    isOrderNumberFound = true;
                }
            }
            if(!isOrderNumberFound) {
                JOptionPane.showMessageDialog(null, "Order Not Found in this List Search in Ready List !");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Enter Correct Order Number !");
        }
    }
    @FXML
    void searchOrderNumberButtonActionListner(ActionEvent event) {
        commonForSearchOrderNumberActionListnerButtonAndTextField();
    }
    
    @FXML
    void searchOrderNumberTextMouseClickedFieldActionListner(MouseEvent event) {
        searchOrderNumberTextField.setText("");
        
    }
    @FXML
    void searchOrderNumberTextFieldActionListner(ActionEvent event) {
        commonForSearchOrderNumberActionListnerButtonAndTextField();
    }
    
    
    
    @FXML
    void cleanButtonActionListner(ActionEvent event) {
        int noOfPaid = 0;
        int noOfUnPaid = 0;
        int amountPaid = 0;
        int amountUnPaid = 0;
        if(cleanedCollectedButton.getText().equals("Collected") || cleanedCollectedButton.getText().equals("")) {
            cleanedCollectedButton.setText("Cleaned");
            orderCleanTableList.clear();
            cleanGroup.setVisible(true);
            mainPane.getChildren().clear();
            mainPane.getChildren().add(cleanGroup);

            for (int i = 0; i < orderArrayList.getList().size(); i++) {
                if (orderArrayList.getList().get(i).getDeliverdate().equals("0000-00-00")) {
                    StringBuilder Items = new StringBuilder();
                    String tempReadyBy = orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(0).getReadyBy();
                    int noOfDresses = 0;
                    boolean isAllClean = false;
                    for (int j = 0; j < orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size(); j++) {
                        noOfDresses = noOfDresses + orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getQuantity();
                        if (orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getWorkingStatus().equals("Clean")){
                            isAllClean = true;
                        }
                        Items.append(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getDressName());
                        if(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size() == 1) {
    //
                        } else {
                            Items.append(" / ");
                        }

                    }
                    if (isAllClean) {
                        if(orderArrayList.getList().get(i).getPaymentStatus().equals("Paid")) {
                            noOfPaid++;
                            amountPaid = amountPaid + orderArrayList.getList().get(i).getTotalPrice();
                        } else {
                            noOfUnPaid++;
                            amountUnPaid = amountUnPaid + orderArrayList.getList().get(i).getTotalPrice();
                        }
                        orderCleanTableList.add(new OrderTableListForClean(orderArrayList.getList().get(i).getOrderNumber(), orderArrayList.getList().get(i).getCustomer().getName(), orderArrayList.getList().get(i).getCustomer().getPhone(), orderArrayList.getList().get(i).getOrderDate(), tempReadyBy, noOfDresses, orderArrayList.getList().get(i).getTotalPrice(), orderArrayList.getList().get(i).getPaymentStatus(), Items.toString()));

                    }
                    noOfPaidLabel.setText(String.valueOf(noOfPaid));
                    noOfUnPaidLabel.setText(String.valueOf(noOfUnPaid));
                    amountPaidLabel.setText(String.valueOf(amountPaid));
                    amountUnPaidLabel.setText(String.valueOf(amountUnPaid));
                 }
                
            }
            
        }
    }
    
    @FXML
    void deliverButtonActionListner(ActionEvent event) {
        
        int discount = 0;
        int no = 0;
        int total = 0;
        int recieved = 0;
        deliveredGroup.setVisible(true);
        orderDeliveredTableList.clear();
        mainPane.getChildren().clear();
        mainPane.getChildren().add(deliveredGroup);
        for (int i = 0; i < orderArrayList.getList().size(); i++) {
            if (!orderArrayList.getList().get(i).getDeliverdate().equals("0000-00-00")) {
                StringBuilder Items = new StringBuilder();
                
                int noOfDresses = 0;
                for (int j = 0; j < orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size(); j++) {
                    noOfDresses = noOfDresses + orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getQuantity();
                    Items.append(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getDressName());
                    if(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size() == 1) {
                    } else {
                        Items.append(" / ");
                    }

                }
                discount = discount + orderArrayList.getList().get(i).getTotalPrice() - orderArrayList.getList().get(i).getCashRecieved();
                total = total + orderArrayList.getList().get(i).getTotalPrice();
                recieved = recieved + orderArrayList.getList().get(i).getCashRecieved();
                no++;
                orderDeliveredTableList.add(new OrderTableListForDelivered(orderArrayList.getList().get(i).getOrderNumber(), orderArrayList.getList().get(i).getCustomer().getName(), orderArrayList.getList().get(i).getCustomer().getPhone(), Items.toString(), noOfDresses, orderArrayList.getList().get(i).getTotalPrice(),orderArrayList.getList().get(i).getCashRecieved(), orderArrayList.getList().get(i).getTotalPrice()-orderArrayList.getList().get(i).getCashRecieved(), orderArrayList.getList().get(i).getOrderDate(),orderArrayList.getList().get(i).getDeliverdate()));
            }
        }
        totalNumberrrrrDLabel.setText(String.valueOf(no));
        totalPriceDLabel.setText(String.valueOf(total));
        discountDLabel.setText(String.valueOf(discount));
        recievedDLabel.setText(String.valueOf(recieved));
    }

    @FXML
    void searchDButtonActionListner(ActionEvent event) {
        //JOptionPane.showMessageDialog(null, "2312 !");
        searchDCommonButtonAction();
    }
    
    @FXML
    void searchDTextFieldActionListnerEnter(ActionEvent event) {
        //JOptionPane.showMessageDialog(null, "1242 !");
        searchDCommonButtonAction();
    }
    
    @FXML
    void searchDTextFieldOnMouseActionListner(MouseEvent event) {
        searchDTextField.setText("");
    }
    
    void searchDCommonButtonAction() {
        if (searchDTextField.getText().charAt(0) == '0' && searchDTextField.getText().charAt(1) == '3' && searchDTextField.getText().length() == 11 ) {
            String phoneTemp;
            boolean isPhoneNumberFound = false;
            try {
                phoneTemp = searchDTextField.getText();
                for (int i = 0; i < orderDeliveredTableList.size(); i++) {
                    if(phoneTemp.equals(orderDeliveredTableList.get(i).getPhone())) {
                        OrderTableListForDelivered orderTableListForDelivered = new OrderTableListForDelivered(orderDeliveredTableList.get(i).getOrderNumber(), orderDeliveredTableList.get(i).getCustomerName(), orderDeliveredTableList.get(i).getPhone(), orderDeliveredTableList.get(i).getItems(), orderDeliveredTableList.get(i).getNoOfdresses(), orderDeliveredTableList.get(i).getPrice(), orderDeliveredTableList.get(i).getRecieved(), orderDeliveredTableList.get(i).getDiscount(), orderDeliveredTableList.get(i).getOrderDate(), orderDeliveredTableList.get(i).getDeliverDate());
                        orderDeliveredTableList.clear();
                        orderDeliveredTableList.add(orderTableListForDelivered);
                        isPhoneNumberFound = true;
                    }
                }
                if(!isPhoneNumberFound) {
                    JOptionPane.showMessageDialog(null, "Phone Number Not Found in this List Search in Clean/Ready List !");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please Enter Correct Phone/Order Number !");
            }
        } else {
            int orderTemp = 0;
            boolean isOrderNumberFound = false;
             
            try {
                orderTemp = Integer.parseInt(searchDTextField.getText());
                for (int i = 0; i < orderDeliveredTableList.size(); i++) {
                    if(orderTemp == orderDeliveredTableList.get(i).getOrderNumber()) {
                        OrderTableListForDelivered orderTableListForDelivered = new OrderTableListForDelivered(orderDeliveredTableList.get(i).getOrderNumber(), orderDeliveredTableList.get(i).getCustomerName(), orderDeliveredTableList.get(i).getPhone(), orderDeliveredTableList.get(i).getItems(), orderDeliveredTableList.get(i).getNoOfdresses(), orderDeliveredTableList.get(i).getPrice(), orderDeliveredTableList.get(i).getRecieved(), orderDeliveredTableList.get(i).getDiscount(), orderDeliveredTableList.get(i).getOrderDate(), orderDeliveredTableList.get(i).getDeliverDate());
                        orderDeliveredTableList.clear();
                        orderDeliveredTableList.add(orderTableListForDelivered);
                        isOrderNumberFound = true;
                    }
                }
                if(!isOrderNumberFound) {
                    JOptionPane.showMessageDialog(null, "Order Not Found in this List Search in Clean/Ready List !");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please Enter Correct Phone/Order Number !");
            }
        }
        
    }
    @FXML
    void cleanedCollectedButtonActionListner(ActionEvent event){//////////////////////////////////////////////////////////////////////////////////////////
        if(orderCTableView.getSelectionModel().getSelectedItem()!= null) {
            OrderTableListForClean orderTableListForClean = orderCTableView.getSelectionModel().getSelectedItem();
            if(cleanedCollectedButton.getText().equals("Cleaned")) {
                for (int i = 0; i < orderArrayList.getList().size(); i++) {
                    if(orderArrayList.getList().get(i).getOrderNumber() == orderTableListForClean.getOrderNumber()) {
                        for (int j = 0; j < orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size(); j++) {
                            orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).setWorkingStatus("Ready");
                            
                        }
                        orderCleanTableList.remove(orderTableListForClean);
                        JOptionPane.showMessageDialog(null, "Order is Moved to Ready List");
                        if(orderTableListForClean.getStatus().equals("Paid")) {
                            noOfPaidLabel.setText(String.valueOf(Integer.parseInt(noOfPaidLabel.getText()) - 1));
                            amountPaidLabel.setText(String.valueOf(Integer.parseInt(amountPaidLabel.getText()) - orderArrayList.getList().get(i).getTotalPrice()));
                        } else {
                            noOfUnPaidLabel.setText(String.valueOf(Integer.parseInt(noOfUnPaidLabel.getText()) - 1));
                            amountUnPaidLabel.setText(String.valueOf(Integer.parseInt(amountUnPaidLabel.getText()) - orderArrayList.getList().get(i).getTotalPrice()));
                        }
                        DataBaseConnection dataBaseConnection = new DataBaseConnection();
                        dataBaseConnection.connectDataBase();
                        int id;
                        
                        String query = "SELECT `id` FROM `orderinfo` WHERE orderNumber = "+orderTableListForClean.getOrderNumber()+" LIMIT 1";
                        ResultSet rs = dataBaseConnection.runSelectQuery(query);
                        try {
                             if(rs.next()) {
                                id = rs.getInt("id");
                                
                                for (int j = 0; j < orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size(); j++) {
                                    query = "UPDATE `orderinfo` SET `workingStatus`= 'Ready' WHERE id = "+id+" AND orderNumber = "+orderArrayList.getList().get(i).getOrderNumber()+" AND dressServiceID = (SELECT `id` FROM `dressandservice`  WHERE dressID = (SELECT id FROM dresses WHERE dName = '"+orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getDressName()+"') AND serviceID = (SELECT id FROM services WHERE sName = '"+orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getService()+"'))";  
                                    
                                    dataBaseConnection.runExecuteUpdate(query);
                                }
                                
                             } else {
                                 JOptionPane.showMessageDialog(null, "Id Not Found ");
                             }
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Id Not Found : (" + e.getMessage() + ")");
                        }
                        
                        break;
                    }
                    
                }
            } else if(cleanedCollectedButton.getText().equals("Collected")) {
                if (orderTableListForClean.getStatus().equals("UnPaid")){
                    totalPriceG152Label1.setText(String.valueOf(orderTableListForClean.getPrice()));
                    totalWithDiscount2.setText(String.valueOf(orderTableListForClean.getPrice()));
                    //mainPane.getChildren().clear();
                    cleanGroup.setVisible(false);
                    mainPane.getChildren().add(recievingCashGroup);
                    
                    recievingCashGroup.setVisible(true);
                    
                    
                } else {
                    for (int i = 0; i < orderArrayList.getList().size(); i++) {
                        if(orderArrayList.getList().get(i).getOrderNumber() == orderTableListForClean.getOrderNumber()) {
                            StringBuilder Items = new StringBuilder();
                            int noOfDresses = 0;
                            
                            for (int j = 0; j < orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size(); j++) {
                                orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).setWorkingStatus("Collected");
                                noOfDresses = noOfDresses + orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getQuantity();
                                Items.append(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getDressName());
                                if(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size() == 1) {
                                } else {
                                    Items.append(" / ");
                                }
                                
                            }
                            orderCleanTableList.remove(orderTableListForClean);
                            JOptionPane.showMessageDialog(null, "Order is Moved to Collected List");
                            if(orderTableListForClean.getStatus().equals("Paid")) {
                                noOfPaidLabel.setText(String.valueOf(Integer.parseInt(noOfPaidLabel.getText()) - 1));
                                amountPaidLabel.setText(String.valueOf(Integer.parseInt(amountPaidLabel.getText()) - orderArrayList.getList().get(i).getTotalPrice()));
                            } else {
                                noOfUnPaidLabel.setText(String.valueOf(Integer.parseInt(noOfUnPaidLabel.getText()) - 1));
                                amountUnPaidLabel.setText(String.valueOf(Integer.parseInt(amountUnPaidLabel.getText()) - orderArrayList.getList().get(i).getTotalPrice()));
                            }
                            orderThatRemoveFromReadyList = orderTableListForClean.getOrderNumber();
                            DataBaseConnection dataBaseConnection = new DataBaseConnection();
                            dataBaseConnection.connectDataBase();
                            

                            LocalDateTime currentTime = LocalDateTime.now();
                            StringBuilder date =  new StringBuilder();
                            date.append(String.valueOf(currentTime).substring(0,4));date.append("-");
                            date.append(String.valueOf(currentTime).substring(5,7));date.append("-");
                            date.append(String.valueOf(currentTime).substring(8,10));
                            orderArrayList.getList().get(i).setDeliverdate(date.toString());
                            String query = "UPDATE `order` SET deliverDate = '"+date.toString()+"' WHERE orderNumber = "+orderTableListForClean.getOrderNumber()+"";
                            dataBaseConnection.runExecuteUpdate(query);
                            query = "SELECT `cashRecieved` FROM `order` WHERE `orderNumber` = "+orderTableListForClean.getOrderNumber()+"";
                            ResultSet rs = dataBaseConnection.runSelectQuery(query);
                            int recievedCash = 0;
                            try {
                                if(rs.next()) {
                                    recievedCash = rs.getInt("cashRecieved");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Recieved Cash not found !");
                                }
                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, "Recieved Cash not found : (" + e.getMessage() + ")");
                            }
                            
                            orderDeliveredTableList.add(new OrderTableListForDelivered(orderArrayList.getList().get(i).getOrderNumber(), orderArrayList.getList().get(i).getCustomer().getName(), orderArrayList.getList().get(i).getCustomer().getPhone(), Items.toString(), noOfDresses, orderArrayList.getList().get(i).getTotalPrice(),orderArrayList.getList().get(i).getCashRecieved(), orderArrayList.getList().get(i).getTotalPrice()-orderArrayList.getList().get(i).getCashRecieved(), orderArrayList.getList().get(i).getOrderDate(),date.toString()));
            
                            break;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error while Setting text to Cleaned and Collected Buttons !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Order !");
        }
    }
    @FXML
    void newOrderButtonActionListner(ActionEvent event) {
        loandryCustomerInfoPane.getChildren().clear();
        loandryCustomerInfoPane.getChildren().add(loandaryButtonsGroup);
        mainPane.getChildren().clear();
        mainPane.getChildren().add(newOrderGroup);
        cleanedCollectedButton.setText("");
       orderInfoTableList.clear();
        customerLabelG1.setText("");
        isCustomerSearched = false;
        newOrder.clearOrderObj();
        
        nameTextField.setText("");
        phoneTextField.setText("");
        adressTextField.setText("");
        emailTextField.setText("");
        discountTextField.setText("0");
        notesTextField.setText("");
        totalPriceG15Label.setText("0");
        cashRecievedTextField.setText("");
        discountG15TextField.setText("");
        totalWithDiscountLabel.setText("0");customerLabelG1.setText("");
        changeLabel.setText("0");
        totalBeneathTableLabel.setText("0");
        customerSearchOrdersLabel.setText("-----------");
    }
    @FXML
    void timeComboBoxActionListner(ActionEvent event) {
        isTimeFromComboBox = true;
        
    }
    
    @FXML
    void readyByDatePickerActionListner(ActionEvent event) {
        
        isDateSlectedFromPicker = true;
        orderInfo.setReadyBy(String.valueOf(readyByDatePicker.getValue()));
    }

    @FXML
    void readyButtonActionListner(ActionEvent event) {///////////////////////////////////////////////////////////////////////////////////////////////////
        int noOfPaid = 0;
        int noOfUnPaid = 0;
        int amountPaid = 0;
        int amountUnPaid = 0;
        
        if(cleanedCollectedButton.getText().equals("Cleaned") || cleanedCollectedButton.getText().equals("")) {
            cleanedCollectedButton.setText("Collected");
            orderCleanTableList.clear();
            cleanGroup.setVisible(true);
            mainPane.getChildren().clear();
            mainPane.getChildren().add(cleanGroup);

            for (int i = 0; i < orderArrayList.getList().size(); i++) {
                if (orderArrayList.getList().get(i).getDeliverdate().equals("0000-00-00")) {
                    StringBuilder Items = new StringBuilder();
                    String tempReadyBy = orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(0).getReadyBy();
                    int noOfDresses = 0;
                    int isAllReady = 0;
                    System.out.println(orderArrayList.getList().get(i).getOrderNumber());
                    for (int j = 0; j < orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size(); j++) {
                            noOfDresses = noOfDresses + orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getQuantity();
                        System.out.println(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getWorkingStatus());
                        if (orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getWorkingStatus().equals("Ready")){
                            isAllReady++;
                        }
                        Items.append(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().get(j).getDressName());
                        if(orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size() == 1) {

                        } else {
                            Items.append(" / ");
                        }

                    }
                    if (isAllReady == orderArrayList.getList().get(i).getOrderInfoArrayList().getList().size()) {
                        if(orderArrayList.getList().get(i).getPaymentStatus().equals("Paid")) {
                            noOfPaid++;
                            amountPaid = amountPaid + orderArrayList.getList().get(i).getTotalPrice();
                        } else {
                            noOfUnPaid++;
                            amountUnPaid = amountUnPaid + orderArrayList.getList().get(i).getTotalPrice();
                        }
                        orderCleanTableList.add(new OrderTableListForClean(orderArrayList.getList().get(i).getOrderNumber(), orderArrayList.getList().get(i).getCustomer().getName(), orderArrayList.getList().get(i).getCustomer().getPhone(), orderArrayList.getList().get(i).getOrderDate(), tempReadyBy, noOfDresses, orderArrayList.getList().get(i).getTotalPrice(), orderArrayList.getList().get(i).getPaymentStatus(), Items.toString()));

                    }
                    noOfPaidLabel.setText(String.valueOf(noOfPaid));
                    noOfUnPaidLabel.setText(String.valueOf(noOfUnPaid));
                    amountPaidLabel.setText(String.valueOf(amountPaid));
                    amountUnPaidLabel.setText(String.valueOf(amountUnPaid));
                }
            
            }
        }
    }
    @FXML
    void addCustomerActionListner(ActionEvent event) {
        
        
        
        loandryCustomerInfoPane.getChildren().clear();
        addCustomerGroup.setVisible(true);
        loandryCustomerInfoPane.getChildren().add(addCustomerGroup);
    }
    
    @FXML
    void searchButtonActionListner(ActionEvent event) {
        loandryCustomerInfoPane.getChildren().clear();
        searchCustomerGroup.setVisible(true);
        loandryCustomerInfoPane.getChildren().add(searchCustomerGroup);
    }
      
    @FXML
    void doneButtonActionListner(ActionEvent event) {
        //readyGroup.setVisible(true); in add customer group
        if(!nameTextField.getText().equals("")) {
            if(!phoneTextField.getText().equals("")) {
                if (phoneTextField.getText().length() == 11 && phoneTextField.getText().charAt(0) == '0' && phoneTextField.getText().charAt(1) == '3') {
                    loandryCustomerInfoPane.getChildren().clear();
                    loandryCustomerInfoPane.getChildren().add(loandaryButtonsGroup);
                    customer.setName(nameTextField.getText());
                    customer.setPhone(phoneTextField.getText());
                    customer.setAdress(adressTextField.getText());
                    customer.setEmail(emailTextField.getText());
                    isCustomerSearched = false;
                    try {
                        customer.setDiscount(Integer.parseInt(discountTextField.getText()));
                    } catch (Exception e) {
                        customer.setDiscount(0);
                    }
                    //orderNumberLabelG1.setText(String.valueOf(newOrder.getOrderNumber()));
                    customerLabelG1.setText(customer.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Number !");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Number !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Name !");
        }
        
    }
    
    @FXML
    void doneCustomerShowButtonActionListner(ActionEvent event) {
        
        if(isCustomerSearched) {
            loandryCustomerInfoPane.getChildren().clear();
            loandryCustomerInfoPane.getChildren().add(loandaryButtonsGroup);
            //orderNumberLabelG1.setText(String.valueOf(OrderNumber));
        } else {
            JOptionPane.showMessageDialog(null, "Please Search Customer !");
        }
        
        
    }
    
    @FXML
    void searchCustomerG15ButtonActionListner(ActionEvent event) {
        if (phoneShowCustomerTextField.getText().length() == 11 && phoneShowCustomerTextField.getText().charAt(0) == '0' && phoneShowCustomerTextField.getText().charAt(1) == '3') {
            Customer customer = new Customer();
            customer = customer.searchCustomer(phoneShowCustomerTextField.getText());
            if(customer==null) {
                JOptionPane.showMessageDialog(null, "Customer Not Found");
            } else {
                StringBuilder customerOrders = new StringBuilder();
                for (int i = 0; i < orderArrayList.getList().size(); i++) {
                    if (orderArrayList.getList().get(i).getCustomer().getPhone().equals(customer.getPhone())) {
                        customerOrders.append(orderArrayList.getList().get(i).getOrderNumber());
                        customerOrders.append(" / ");
                    }
                }
                customerSearchOrdersLabel.setText(customerOrders.toString());
                nameShowCustomerLabel.setText(customer.getName());
                adressShowCustomerLabel.setText(customer.getAdress());
                noteShowCustomerLabel.setText(customer.getNote());
                discountShowCustomerLabel.setText(String.valueOf(customer.getDiscount()));
                customerLabelG1.setText(customer.getName());
                isCustomerSearched = true;
                newOrder.setCustomer(new Customer(customer.getName(), customer.getPhone(), customer.getAdress(), customer.getEmail(), customer.getDiscount(), customer.getNote()));
                //System.out.println(newOrder.getCustomer().getName());
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "wrong number !");
        }
    }
    
    @FXML
    void cancelCustomerG15ButtonActionListner(ActionEvent event) {
        //JOptionPane.showMessageDialog(null, "Customer is not Selected !");
        loandryCustomerInfoPane.getChildren().clear();
        loandryCustomerInfoPane.getChildren().add(loandaryButtonsGroup);
        customerSearchOrdersLabel.setText("----------");
        nameShowCustomerLabel.setText("");
        adressShowCustomerLabel.setText("");
        noteShowCustomerLabel.setText("");
        discountShowCustomerLabel.setText("");
        customerLabelG1.setText("");

    }
    
    //loandary Buttons
    
    @FXML
    void boaskiSuiteButtonActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Boaski Suite");
    }
    @FXML
    void karandeeSuiteButtonActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Karandi Suite");
    }
    @FXML
    void khadarSuiteButtonActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Khadar Suite");
    }
    @FXML
    void kameezOnlyButtonActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Kameez Only");
    }
    @FXML
    void shalwarOnlyButtonActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Shalwar Only");
    }
    
    @FXML
    void shalwarKameezActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Shalwar kameez");
    }
    @FXML
    void sherwaniActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Sherwani");
    }
    @FXML
    void pentCoatActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Pent Coat");
    }
    @FXML
    void coatActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Coat");
    }
    @FXML
    void jeansActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Jeans");
    }
    @FXML
    void dressShirtActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Dress Shirt");
    }
    @FXML
    void tShirtActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("T-Shirt");
    }
    @FXML
    void jacketActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Jacket");
    }
    @FXML
    void longCoatActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Waistcoat");
    }
    @FXML
    void lehngaActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Lehnga/Sardhi");
    }
    @FXML
    void womenSuiteActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Women Suite");
    }
    @FXML
    void curtainActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Curtain");
    }
    @FXML
    void blanketActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Blanket");
    }
    @FXML
    void bedsheetActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Bed Sheet");
    }
    @FXML
    void underGarmentsActionListner(ActionEvent event) {
        loandaryButtonsCommonFunction("Under Garments");
    }
    void loandaryButtonsCommonFunction(String name){
        loandryCustomerInfoPane.getChildren().clear();
        loandaryButtonsInfoGroup.setVisible(true);
        loandryCustomerInfoPane.getChildren().add(loandaryButtonsInfoGroup);
        loundaryButtonsDetector = name;
    }
    String reversString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return sb.reverse().toString();
    }
    @FXML
    void doneG3ActionListner(ActionEvent event) {
        orderInfoIdCounter = 1;
        if (isDateSlectedFromPicker) {
            
            try {
                if(!timeComboBox.getValue().equals("")){
                    if(addQtyTextField.getText().equals("") || addQtyTextField.getText().equals("0")) {
                        JOptionPane.showMessageDialog(null, "Please Select Quantity of Item !");
                    } else {
                        //System.out.println("dc.MainMenuCghfghjhsfa)");
                        loandryCustomerInfoPane.getChildren().clear();
                        loandryCustomerInfoPane.getChildren().add(loandaryButtonsGroup);
                        RadioButton selectedRadioBttonWashClean = (RadioButton) washClean.getSelectedToggle();
                        String tempService = "";
                        if (selectedRadioBttonWashClean.getText().equals("Wash And Press")){
                            tempService = "W & P";
                        } else if (selectedRadioBttonWashClean.getText().equals("Wash Only")){
                            tempService = "W";
                        } else {
                            tempService = "P";
                        }

                        int tempPricePerItem = 0;
                        int tempQty = Integer.parseInt(addQtyTextField.getText());
                        for (int i = 0; i < 48; i++) {
                            if(dressAndServicePriceArrayList.getList().get(i).getDress().equals(loundaryButtonsDetector) && dressAndServicePriceArrayList.getList().get(i).getService().equals(selectedRadioBttonWashClean.getText())){
                                tempPricePerItem = dressAndServicePriceArrayList.getList().get(i).getPrice();
                                //System.out.println("dc.MainMenuController.doneG3ActionListner()");
                                break;
                            }
                        }
                        RadioButton selectedRadioBttonAmPm = (RadioButton) AmPm.getSelectedToggle();

                        totalBeneathTableLabel.setText(String.valueOf(Integer.parseInt(totalBeneathTableLabel.getText()) + tempPricePerItem*tempQty));


                        orderInfoTableList.add(new OrderInfo(orderInfoIdCounter,loundaryButtonsDetector,tempService, tempPricePerItem, tempQty, (tempQty*tempPricePerItem)));

                        orderInfoArrayList.addOrderInfo(new OrderInfo(orderInfoIdCounter, loundaryButtonsDetector, selectedRadioBttonWashClean.getText(), tempPricePerItem, tempQty, (tempQty*tempPricePerItem), readyByDatePicker.getValue().format(DateTimeFormatter.ISO_DATE), timeComboBox.getValue() + selectedRadioBttonAmPm.getText(), issuesLabel.getText(), "clean"));
                        orderInfoIdCounter++;
                        issuesLabel.setText("");
                        addQtyTextField.setText("1");
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select Time2 !");
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please Select Time !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Ready By Date !");
        }
        
        
    }
    
    @FXML
    void generateSlipButtonActionListner(ActionEvent event) {
        
        if(orderInfoArrayList.getList().size()>0){
            if (!customerLabelG1.getText().equals("")) {
                newOrder.setOrderNumber(OrderNumber);
                LocalDateTime currentTime = LocalDateTime.now();
                //buiding time string 
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    s.append(String.valueOf(currentTime).charAt(i));
                }
                newOrder.setOrderDate(s.toString());
                if (!isCustomerSearched) {
                    newOrder.setCustomer(customer);
                }
                //System.out.println(newOrder.getCustomer().getName());
                newOrder.setOrderInfoArrayList(orderInfoArrayList);
                
                RadioButton selectedRadioBtton = (RadioButton) paymentMethod.getSelectedToggle();
                if (selectedRadioBtton.getText().equals("Pay Now")){
                    loandryCustomerInfoPane.getChildren().clear();
                    generatSlipGroup.setVisible(true);
                    loandryCustomerInfoPane.getChildren().add(generatSlipGroup);
                    newOrder.setPaymentStatus("Paid");
                    totalPriceG15Label.setText(String.valueOf(newOrder.getTotalPrice()));
                    totalWithDiscountLabel.setText(String.valueOf(newOrder.getTotalPrice()));
                    
                    
                } else {
                    loandryCustomerInfoPane.getChildren().clear();
                    generatSlipGroup.setVisible(true);
                    loandryCustomerInfoPane.getChildren().add(generatSlipGroup);
                    newOrder.setPaymentStatus("UnPaid");
                    newOrder.setCashRecieved(0);
                    orderNumberLabelG1.setText(String.valueOf(OrderNumber));
                    newOrder.setOrderNumber(OrderNumber);
                    totalPriceG15Label.setText(String.valueOf(newOrder.getTotalPrice()));
                    totalWithDiscountLabel.setText(String.valueOf(newOrder.getTotalPrice()));
                    
                    
                    cashRecievedTextField.setDisable(true);
                    //okcashRecievedButton.setDisable(true);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Please Add or Select by Searching Customer !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Items !");
        }
    }
    
    @FXML
    void printAndSaveButtonActionListner(ActionEvent event) {
        if (newOrder.getPaymentStatus().equals("Paid")) {
            loandryCustomerInfoPane.getChildren().clear();
            loandryCustomerInfoPane.getChildren().add(loandaryButtonsGroup);
            try {
                newOrder.setCashRecieved((int)Float.parseFloat(totalWithDiscountLabel.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Number format Error while recieving cash !");
            }
            //newOrder.addOrder(newOrder,isCustomerSearched);
            generateSlip("Paid");
        } else {
            loandryCustomerInfoPane.getChildren().clear();
            loandryCustomerInfoPane.getChildren().add(loandaryButtonsGroup);
            
            //newOrder.addOrder(newOrder,isCustomerSearched);
            generateSlip("Not Paid");
        }      
        
    }
    void generateSlip(String status){
        String order = "";
        order = manageString(String.valueOf(newOrder.getOrderNumber()),15);//////
        StringBuilder text2 = new StringBuilder();            
        int i;
        for (i = 0; i < newOrder.getOrderInfoArrayList().getList().size(); i++) {
            
            text2.append(manageString(String.valueOf(i+1), 2));
            text2.append(" | ");
            text2.append(manageString(newOrder.getOrderInfoArrayList().getList().get(i).getDressName(),14));
            text2.append(" | ");
            if(newOrder.getOrderInfoArrayList().getList().get(i).getService().contains("And")) {
                text2.append("W&P ");
            } else if (newOrder.getOrderInfoArrayList().getList().get(i).getService().equals("Wash Only")){
                text2.append("W   ");
            } else {
                text2.append("P   ");
            }
            text2.append(" | ");
            text2.append(manageString(String.valueOf(newOrder.getOrderInfoArrayList().getList().get(i).getQuantity()),3));
            text2.append(" | ");
            text2.append(manageString(String.valueOf(newOrder.getOrderInfoArrayList().getList().get(i).getPrice()),4));
            text2.append(" | ");
            text2.append(manageString(String.valueOf(newOrder.getOrderInfoArrayList().getList().get(i).getTotalPrice()),5));
            text2.append("\n");
        }
        //String t;
        LocalDateTime currentTime = LocalDateTime.now();
        
        String customer = newOrder.getCustomer().getName();
        String phone = newOrder.getCustomer().getPhone();
        StringBuilder date =  new StringBuilder();
        date.append(String.valueOf(currentTime).substring(8,10));date.append("-");
        date.append(String.valueOf(currentTime).substring(5,7));date.append("-");
        date.append(String.valueOf(currentTime).substring(0,4));
        String grossTotal  = totalPriceG15Label.getText();
        String nettotal  = totalWithDiscountLabel.getText();
        float discount;
        try {
            discount = Integer.parseInt(discountG15TextField.getText());
        } catch (NumberFormatException e) {
            discount = 0;
        }
        String recived;
        String discountV  = String.valueOf((int)Integer.parseInt(grossTotal)*(discount/100));//
        if(status.equals("Paid")){
            recived  = cashRecievedTextField.getText();
        } else {
            recived = "0";
        }
        
        String balance  = changeLabel.getText();
        String readyBy = newOrder.getOrderInfoArrayList().getList().get(i-1).getReadyBy();
        
        StringBuilder finalText = new StringBuilder();
        
        String time = newOrder.getOrderInfoArrayList().getList().get(i-1).getTime();
         
   String text1 = "             ** SHAFIQUE & SON'S **            \n"//47 char per line
                + "                  Dry Cleaners                 \n"
                + "Main Ahloo Road, Opp.of PSO Pump, kahna Nou LHR\n"
                + "                 (Branch No-05)                \n"
                + "                Ph : 03214332138               \n"
                + "                                               \n"
                + "-----------------------------------------------\n"
                + "                                               \n"
                + "                                               \n"
                + "Order # : "+order+"     Date : "+date.toString()+"\n"
                + "Customer: "+customer+"\n"
                + "Phone   : "+phone+"\n\n"
                + "_______________________________________________\n"
                + "NO | Item           | Serv | Qty | Pric | Total\n"
                + "_______________________________________________\n";
   
   String text3 = "_______________________________________________\n"
                + "                                               \n"
                + "                              Gross Total : "+manageString(String.valueOf(grossTotal),5)+"\n"
                + "                                               \n"
                + "Ready By : "+setDateOrder(readyBy)+"       Discount    : "+manageString(String.valueOf(discountV),5)+"\n"
                + "Time     : "+manageString(time, 5)+"            Net Total   : "+manageString(String.valueOf(nettotal),5)+"\n"
                + "Payment  : "+manageString(status, 8)+"         Recieved    : "+manageString(String.valueOf(recived),5)+"\n"
                + "                            Balance     : "+manageString(String.valueOf(balance),5)+"\n"
                + "                                           \n\n\n"
                + " Term and Condition **                         \n"
                + "                                               \n"
                + " 1 - The customer must pay the agreed-upon     \n"
                + " charges prior to service.                     \n"
                + " 2 - No Payment will be ReFund after Order is  \n"
                + " Placed.                                       \n"
                + " 3 - Picking up the Items is the Customer's    \n"
                + " responsibilty.                                \n"
                + " 4 - In the rare Case that your garment is     \n"
                + " damaged by us, we will issue you a 50% refund \n"
                + " and if garment is lost we will give you same  \n"
                + " garment of your size within 15 days.          \n"
                + " 5 - Customers are responsible to mention all  \n"
                + " the stains when they leave the garments here. \n"
                + "                                         \n\n\n\n"
                + "            Thank You For Visiting             \n"
                + "    (Software Devolped By Mian Hamza Saqib)    \n"
                + "              (Ph : 03239991999)     \n\n\n\n\n\n";
        finalText.append(text1);
        finalText.append(text2);
        finalText.append(text3);
        
        PrinterService p = new PrinterService();
        p.printString("BC-95AC", finalText.toString());
        byte[] cutP = new byte[] { 0x1d, 'V', 1 };

        p.printBytes("BC-95AC", cutP);
        JOptionPane.showMessageDialog(null, "Take Slip From printer !");
        
        
        newOrder.addOrder(newOrder, isCustomerSearched);
        orderArrayList.addOrder(new Order(OrderNumber, date.toString(), "0000-00-00", status, 0, new Customer(customer, phone, newOrder.getCustomer().getAdress(), newOrder.getCustomer().getEmail(), newOrder.getCustomer().getDiscount(), newOrder.getCustomer().getNote()), new OrderInfoArrayList()));
        for (int j = 0; j < orderArrayList.getList().size(); j++) {
            if (orderArrayList.getList().get(j).getOrderNumber() == OrderNumber) {
                for (int k = 0; k < newOrder.getOrderInfoArrayList().getList().size(); k++) {
                    orderArrayList.getList().get(j).getOrderInfoArrayList().getList().add(new OrderInfo(k+1, newOrder.getOrderInfoArrayList().getList().get(k).getDressName(), newOrder.getOrderInfoArrayList().getList().get(k).getService(), newOrder.getOrderInfoArrayList().getList().get(k).getPrice(), newOrder.getOrderInfoArrayList().getList().get(k).getQuantity(), newOrder.getOrderInfoArrayList().getList().get(k).getTotalPrice(), newOrder.getOrderInfoArrayList().getList().get(k).getReadyBy(), newOrder.getOrderInfoArrayList().getList().get(k).getTime(), newOrder.getOrderInfoArrayList().getList().get(k).getIssues(), "Clean"));
                }
                break;
            }
        }
        clearEverything();
        OrderNumber++;
        orderNumberLabelG1.setText(String.valueOf(OrderNumber));
        newOrder.setOrderNumber(OrderNumber);
    }
    String setDateOrder(String temp) {
        StringBuilder date = new StringBuilder();
        date.append(temp.substring(8, 10));date.append("-");
        date.append(temp.substring(5, 7));date.append("-");
        date.append(temp.substring(0, 4));
        return date.toString();
    }
     String manageString(String text, int size) {
         StringBuilder temp = new StringBuilder();
         temp.append(text);
         for (int i = 0; i < size - text.length(); i++) {
             temp.append(" ");
         }
         return temp.toString();
     }
    
     @FXML
    void discountOkButonAcionListner(ActionEvent event) {
        
        discount(newOrder.getPaymentStatus());
    }
     @FXML
    void cashRecievedOkButonAcionListner(ActionEvent event) {
        cashRecieved();
    }
     void cashRecieved() {
        cashRecievedTextField.setDisable(false);
         
        int total = 0;
        int cashRecieved = 0;
        float discount = 0;
        int totalWithDiscount = 0;
        int change = 0;
        total = Integer.parseInt(totalPriceG15Label.getText());
        try {
            
            cashRecieved = Integer.parseInt(cashRecievedTextField.getText());
            //discount = Float.valueOf(discountG15TextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Inter Cash Recieved, Not in Points !");
        }
        totalWithDiscount = total;
        JOptionPane.showMessageDialog(null, totalWithDiscount);
        JOptionPane.showMessageDialog(null, cashRecieved);
        //JOptionPane.showMessageDialog(null, "1");
        if(cashRecieved >= totalWithDiscount) {
            if (discount > 0 && discount < 100) {
                //JOptionPane.showMessageDialog(null, "1");
                totalWithDiscount = (int)(total - total*(discount/100));
                change = cashRecieved - totalWithDiscount;
                this.totalWithDiscountLabel.setText(String.valueOf((int)totalWithDiscount));
                changeLabel.setText(String.valueOf((int)change));
            } else if (discount <= 0) {
                JOptionPane.showMessageDialog(null, "2");
                this.totalWithDiscountLabel.setText(String.valueOf((int)totalWithDiscount));
                change = cashRecieved - totalWithDiscount;
                changeLabel.setText(String.valueOf((int)change));
            } else if (discount >= 100) {
                totalWithDiscount = 0;
                change = cashRecieved - totalWithDiscount;
                this.totalWithDiscountLabel.setText(String.valueOf((int)totalWithDiscount));
                changeLabel.setText(String.valueOf((int)change));
            } else {
                //do nothing
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Check your Cash again its less than Net Total price !");
        }
     }
    @FXML
    void cashRecievedTextFieldActionListner(ActionEvent event) {
        cashRecieved();
    }
    
    void discount(String s){
        //JOptionPane.showMessageDialog(null, "1 !");
        int total = 0;
        int cashRecieved = 0;
        float discount = 0;
        int totalWithDiscount = 0;
        int change = 0;
        total = Integer.parseInt(totalPriceG15Label.getText());
        discount = Integer.parseInt(discountG15TextField.getText());
        //JOptionPane.showMessageDialog(null, "2 !");
        if(s.equals(("Paid"))){
            //JOptionPane.showMessageDialog(null, "here !");
            try {
                cashRecieved = Integer.parseInt(cashRecievedTextField.getText());
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please Inter Cash Recieved, Not in Points !");
            }
            
            totalWithDiscount = total;
            if(cashRecieved >= totalWithDiscount) {
                if (discount > 0 && discount < 100) {
                    totalWithDiscount = (int)(total - total*(discount/100));
                    change = cashRecieved - totalWithDiscount;
                    this.totalWithDiscountLabel.setText(String.valueOf((int)totalWithDiscount));
                    changeLabel.setText(String.valueOf((int)change));
                } else if (discount <= 0) {
                    this.totalWithDiscountLabel.setText(String.valueOf((int)totalWithDiscount));
                    change = cashRecieved - totalWithDiscount;
                    changeLabel.setText(String.valueOf((int)change));
                } else if (discount >= 100) {
                    totalWithDiscount = 0;
                    change = cashRecieved - totalWithDiscount;
                    this.totalWithDiscountLabel.setText(String.valueOf((int)totalWithDiscount));
                    changeLabel.setText(String.valueOf((int)change));
                } else {
                    //do nothing
                }
            }
        }
        totalWithDiscount = total;
        
        
        if (discount > 0 && discount < 100) {
            
            totalWithDiscount = (int)(total - total*(discount/100));
            //JOptionPane.showMessageDialog(null, totalWithDiscount);
            //change = cashRecieved - totalWithDiscount;
            totalWithDiscountLabel.setText(String.valueOf((int)totalWithDiscount));
            //changeLabel.setText(String.valueOf((int)change));
        } else if (discount <= 0) {
            totalWithDiscountLabel.setText(String.valueOf((int)totalWithDiscount));
            ////change = cashRecieved - totalWithDiscount;
            ///changeLabel.setText(String.valueOf((int)change));
        } else if (discount >= 100) {
            totalWithDiscount = 0;
            //change = cashRecieved - totalWithDiscount;
            totalWithDiscountLabel.setText(String.valueOf((int)totalWithDiscount));
            //changeLabel.setText(String.valueOf((int)change));
        } else {
            //do nothing
        }

        
          
    }
    
    @FXML
    void discountG15TextFieldActionListner(ActionEvent event) {
        
         discount(newOrder.getPaymentStatus());
        
    }
    
    @FXML
    void mainMenuBarActionListner(ActionEvent event) {
        
        ScreenController screenController = new ScreenController("DressesAndServicesPrice.fxml", "Dress and Service Prices");
        screenController.start();

    }
    ///////////////G1 -----G3
    //colors
    
    @FXML
    void redButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Red/");
    }
    
    @FXML
    void greenButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Green/");
    }
    @FXML
    void blueButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Blue/");
    }
    @FXML
    void purpleButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Purple/");
    }
    @FXML
    void whiteButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"White/");
    }
    @FXML
    void blackButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Black/");
    }
    
    @FXML
    void creemButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Cream/");
    }
    @FXML
    void pinkButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Pink/");
    }
    @FXML
    void brownButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Brown/");
    }
    
    @FXML
    void greyButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Grey/");
    }
    /// other issues
    @FXML
    void teaButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Tea/");
    }
    @FXML
    void ironMarkButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Iron Mark/");
    }
    
    @FXML
    void buttonBrokenButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Button Broken/");
    }
    
    @FXML
    void holesButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Holes/");
    }
    @FXML
    void foodButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Food/");
    }
    @FXML
    void oilButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Oil/");
    }
    @FXML
    void paintButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Pain/");
    }
    @FXML
    void greaseButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Grease/");
    }
    @FXML
    void mudButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Mud/");
    }
    @FXML
    void bloodButtonActionListner(ActionEvent event) {
        issuesLabel.setText(issuesLabel.getText()+"Blood/");
    }
    
    @FXML
    void issuesClearButtonActionListner(ActionEvent event) {
        issuesLabel.setText("");
    }
    
    
    
    void clearEverything(){
        orderInfoTableList.clear();
        customerLabelG1.setText("");
        isCustomerSearched = false;
        newOrder.clearOrderObj();
        newOrder.getOrderInfoArrayList().getList().clear();
        newOrder.getCustomer().clearCustomer();
        nameTextField.setText("");
        phoneTextField.setText("");
        adressTextField.setText("");
        emailTextField.setText("");
        discountTextField.setText("0");
        notesTextField.setText("");
        totalPriceG15Label.setText("0");
        cashRecievedTextField.setText("");
        discountG15TextField.setText("");
        totalWithDiscountLabel.setText("0");customerLabelG1.setText("");
        changeLabel.setText("0");
        totalBeneathTableLabel.setText("0");
        customerSearchOrdersLabel.setText("-----------");
    }
    
    //////////////////////////////
    @FXML
    void cleanedButtonActionListner(ActionEvent event) {
        
    }
}
