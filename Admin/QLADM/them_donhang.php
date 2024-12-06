<?php
include 'DonHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$donHang = new DonHang($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nguoiDungID = $_POST['nguoiDungID'];
    $trangThai = $_POST['trangThai'];
    
    if ($donHang->them($nguoiDungID, $trangThai)) {
        header("Location: admin_donhang.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Đơn Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Đơn Hàng</h2>
    <form method="POST">
        <div class="form-group">
            <label for="nguoiDungID">Người Dùng ID:</label>
            <input type="number" class="form-control" id="nguoiDungID" name="nguoiDungID" required>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng Thái:</label>
            <select class="form-control" id="trangThai" name="trangThai">
                <option value="Đang xử lý">Đang xử lý</option>
                <option value="Đã giao">Đã giao</option>
                <option value="Đã hủy">Đã hủy</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Thêm</button>
        <a href="admin_donhang.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
