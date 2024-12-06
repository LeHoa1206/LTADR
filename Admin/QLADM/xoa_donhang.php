<?php
include 'DonHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$donHang = new DonHang($conn);

if (isset($_GET['id'])) {
    $donHang->xoa($_GET['id']);
    header("Location: admin_donhang.php");
    exit();
}
?>
