<?php
include 'ThanhToan.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$thanhToan = new ThanhToan($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $donHangID = $_POST['donHangID'];
    $phuongThuc = $_POST['phuongThuc'];
    $trangThai = $_POST['trangThai'];
    $soTien = $_POST['soTien'];
    $thoiGian = $_POST['thoiGian'];

    if ($thanhToan->them($donHangID, $phuongThuc, $trangThai, $soTien, $thoiGian)) {
        header("Location: admin_dashboard_thanh_toan.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Thanh Toán</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Thanh Toán</h2>
    <form method="POST">
        <div class="form-group">
            <label for="donHangID">ID Đơn Hàng:</label>
            <input type="number" class="form-control" id="donHangID" name="donHangID" required>
        </div>
        <div class="form-group">
            <label for="phuongThuc">Phương Thức Thanh Toán:</label>
            <select class="form-control" id="phuongThuc" name="phuongThuc" required>
                <option value="Tiền mặt">Tiền mặt</option>
                <option value="Chuyển khoản">Chuyển khoản</option>
                <option value="Ví điện tử">Ví điện tử</option>
            </select>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng Thái Thanh Toán:</label>
            <select class="form-control" id="trangThai" name="trangThai" required>
                <option value="Đã thanh toán">Đã thanh toán</option>
                <option value="Chưa thanh toán">Chưa thanh toán</option>
                <option value="Thanh toán không thành công">Thanh toán không thành công</option>
            </select>
        </div>
        <div class="form-group">
            <label for="soTien">Số Tiền Thanh Toán:</label>
            <input type="number" step="0.01" class="form-control" id="soTien" name="soTien" required>
        </div>
        <div class="form-group">
            <label for="thoiGian">Thời Gian Thanh Toán:</label>
            <input type="datetime-local" class="form-control" id="thoiGian" name="thoiGian" required>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
        <a href="admin_dashboard_thanh_toan.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
