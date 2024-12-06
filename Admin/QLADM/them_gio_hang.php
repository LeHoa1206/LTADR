<?php
include 'GioHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$gioHang = new GioHang($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nguoiDungID = $_POST['nguoiDungID'];
    $sanPhamID = $_POST['sanPhamID'];
    $soLuong = $_POST['soLuong'];

    if ($gioHang->them($nguoiDungID, $sanPhamID, $soLuong)) {
        header("Location: admin_dashboard_gio_hang.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Giỏ Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Giỏ Hàng</h2>
    <form method="POST">
        <div class="form-group">
            <label for="nguoiDungID">ID Người Dùng:</label>
            <input type="number" class="form-control" id="nguoiDungID" name="nguoiDungID" required>
        </div>
        <div class="form-group">
            <label for="sanPhamID">ID Sản Phẩm:</label>
            <input type="number" class="form-control" id="sanPhamID" name="sanPhamID" required>
        </div>
        <div class="form-group">
            <label for="soLuong">Số Lượng:</label>
            <input type="number" class="form-control" id="soLuong" name="soLuong" required>
        </div>
        <button type="submit" class="btn btn-success">Thêm</button>
        <a href="admin_dashboard_gio_hang.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
