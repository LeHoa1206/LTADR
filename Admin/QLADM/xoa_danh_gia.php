<?php
include 'DanhGia.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$danhGia = new DanhGia($conn);

if (isset($_GET['id'])) {
    $danhGia->xoa($_GET['id']);
    header("Location: admin_dashboard_danh_gia.php");
    exit();
}
?>
