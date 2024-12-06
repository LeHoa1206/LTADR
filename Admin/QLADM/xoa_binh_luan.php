<?php
include 'BinhLuan.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$binhLuan = new BinhLuan($conn);

if (isset($_GET['id'])) {
    $binhLuanItem = $binhLuan->layTheoId($_GET['id']);
    $binhLuan->xoa($_GET['id']);
    header("Location: chi_tiet_san_pham.php?id=" . $binhLuanItem['SanPhamID']);
    exit();
}
?>
