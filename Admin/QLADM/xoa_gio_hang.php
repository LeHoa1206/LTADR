<?php
include 'GioHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$gioHang = new GioHang($conn);

if (isset($_GET['id'])) {
    $gioHang->xoa($_GET['id']);
    header("Location: admin_dashboard_gio_hang.php");
    exit();
}
?>
