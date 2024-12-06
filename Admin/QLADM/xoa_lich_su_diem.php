<?php
include 'LichSuDiem.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$lichSuDiem = new LichSuDiem($conn);

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $id = $_GET['id'];
    if ($lichSuDiem->xoa($id)) {
        header("Location: admin_dashboard_lich_su_diem.php");
        exit();
    }
}
?>
