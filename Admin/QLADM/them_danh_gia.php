<?php
include 'DanhGia.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$danhGia = new DanhGia($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nguoiDungID = $_POST['nguoiDungID'];
    $sanPhamID = $_POST['sanPhamID'];
    $noiDung = $_POST['noiDung'];
    $diem = $_POST['diem'];

    if ($danhGia->them($nguoiDungID, $sanPhamID, $noiDung, $diem)) {
        header("Location: admin_dashboard_danh_gia.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Đánh Giá</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Đánh Giá</h2>
    <form method="POST">
        <div class="form-group">
            <label for="nguoiDungID">Người Dùng ID:</label>
            <input type="number" class="form-control" id="nguoiDungID" name="nguoiDungID" required>
        </div>
        <div class="form-group">
            <label for="sanPhamID">Sản Phẩm ID:</label>
            <input type="number" class="form-control" id="sanPhamID" name="sanPhamID" required>
        </div>
        <div class="form-group">
            <label for="noiDung">Nội Dung:</label>
            <textarea class="form-control" id="noiDung" name="noiDung" required></textarea>
        </div>
        <div class="form-group">
            <label for="diem">Điểm:</label>
            <input type="number" class="form-control" id="diem" name="diem" min="1" max="5" required>
        </div>
        <button type="submit" class="btn btn-primary">Thêm Đánh Giá</button>
        <a href="admin_dashboard_danh_gia.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
