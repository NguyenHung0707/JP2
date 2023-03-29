package hello.nguyemhung04;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Collection;
import java.sql.*;

public class Product {

    @FXML
    private Label label;

    @FXML
    private TextField btnID;

    @FXML
    private TextField btnName;

    @FXML
    private TextField btnDescription;

    @FXML
    private  TextField btnPrice;
    @FXML
    private TextField btnQty;




    public void AddonClick(ActionEvent actionEvent) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                PreparedStatement pstm = conn.prepareStatement("insert into product (ID, Name, Description, Price, Qty) values (?, ?, ?, ?, ?)");

        ){
                    pstm.setString(1,btnID.getText());
                    pstm.setString(2,btnName.getText());
                    pstm.setString(3,btnDescription.getText());
                    pstm.setString(4,btnPrice.getText());
                    pstm.setString(5,btnQty.getText());

                    int check = pstm.executeUpdate();
                    if(check > 0){
                        label.setText("Bạn đã thêm sản phẩm thành công!");
                    }else {
                        label.setText("Sản phẩm của bạn chưa được thêm vào!");
                    }
        } catch (SQLException e) {
            System.out.println(e.toString());
            label.setText("Lỗi cơ sở dữ liệu");
        }
    }

    public void UpdateonClick(ActionEvent actionEvent) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                PreparedStatement pstm = conn.prepareStatement("update product set Name = ? where ID = ?");

        ){
            pstm.setString(2,btnID.getText());
            pstm.setString(1,btnName.getText());


            int check = pstm.executeUpdate();
            if(check > 0){
                label.setText("Cập nhật sản phẩm thành công!");
            }else {
                label.setText("Sản phẩm của bạn chưa được cập nhật!");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            label.setText("Lỗi cơ sở dữ liệu");
        }
    }

    public void DeleteonClick(ActionEvent actionEvent) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                PreparedStatement pstm = conn.prepareStatement("delete from product where ID = ?");

        ){
            pstm.setString(1,btnID.getText());


            int check = pstm.executeUpdate();
            if(check > 0){
                label.setText("Xóa sản phẩm thành công!");
            }else {
                label.setText("Xóa sản phẩm thất bại!");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            label.setText("Lỗi cơ sở dữ liệu");
        }
    }
}
