<?php
include 'ChiTietDonHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$chiTietDonHang = new ChiTietDonHang($conn);

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $id = $_GET['id'];
    if ($chiTietDonHang->xoa($id)) {
        header("Location: admin_dashboard_chi_tiet_don_hang.php");
        exit();
    }
}
?>
