<?php
include 'ThanhToan.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$thanhToan = new ThanhToan($conn);

if (isset($_GET['id'])) {
    $id = $_GET['id'];
    $thanhToan->xoa($id);
    header("Location: admin_dashboard_thanh_toan.php");
    exit();
}
?>
