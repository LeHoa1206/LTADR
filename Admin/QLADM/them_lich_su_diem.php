<?php
include 'LichSuDiem.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$lichSuDiem = new LichSuDiem($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nguoiDungID = $_POST['nguoiDungID'];
    $diemThang = $_POST['diemThang'];

    if ($lichSuDiem->them($nguoiDungID, $diemThang)) {
        header("Location: admin_dashboard_lich_su_diem.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Lịch Sử Điểm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Lịch Sử Điểm</h2>
    <form method="POST">
        <div class="form-group">
            <label for="nguoiDungID">Người Dùng ID:</label>
            <input type="number" class="form-control" id="nguoiDungID" name="nguoiDungID" required>
        </div>
        <div class="form-group">
            <label for="diemThang">Điểm Tháng:</label>
            <input type="number" class="form-control" id="diemThang" name="diemThang" required>
        </div>
        <button type="submit" class="btn btn-success">Thêm</button>
        <a href="admin_dashboard_lich_su_diem.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
