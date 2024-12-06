<?php
include 'SanPham.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$sanPham = new SanPham($conn);

if (isset($_GET['id'])) {
    $sanPham->xoa($_GET['id']);
    header("Location: admin_dashboard_san_pham.php");
    exit();
}
?>
