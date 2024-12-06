<?php
include 'ThanhToan.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$thanhToan = new ThanhToan($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $id = $_POST['thanhToanID'];
    $donHangID = $_POST['donHangID'];
    $phuongThuc = $_POST['phuongThuc'];
    $trangThai = $_POST['trangThai'];
    $soTien = $_POST['soTien'];
    $thoiGian = $_POST['thoiGian'];

    if ($thanhToan->sua($id, $phuongThuc, $trangThai, $soTien, $thoiGian)) {
        header("Location: admin_dashboard_thanh_toan.php");
        exit();
    }
} else {
    $id = $_GET['id'];
    $item = $thanhToan->layTheoId($id);
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Thanh Toán</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Sửa Thanh Toán</h2>
    <form method="POST">
        <input type="hidden" name="thanhToanID" value="<?php echo $item['ThanhToanID']; ?>">
        <div class="form-group">
            <label for="donHangID">ID Đơn Hàng:</label>
            <input type="number" class="form-control" id="donHangID" name="donHangID" value="<?php echo $item['DonHangID']; ?>" required>
        </div>
        <div class="form-group">
            <label for="phuongThuc">Phương Thức Thanh Toán:</label>
            <select class="form-control" id="phuongThuc" name="phuongThuc" required>
                <option value="Tiền mặt" <?php if($item['PhuongThucThanhToan'] == 'Tiền mặt') echo 'selected'; ?>>Tiền mặt</option>
                <option value="Chuyển khoản" <?php if($item['PhuongThucThanhToan'] == 'Chuyển khoản') echo 'selected'; ?>>Chuyển khoản</option>
                <option value="Ví điện tử" <?php if($item['PhuongThucThanhToan'] == 'Ví điện tử') echo 'selected'; ?>>Ví điện tử</option>
            </select>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng Thái Thanh Toán:</label>
            <select class="form-control" id="trangThai" name="trangThai" required>
                <option value="Đã thanh toán" <?php if($item['TrangThaiThanhToan'] == 'Đã thanh toán') echo 'selected'; ?>>Đã thanh toán</option>
                <option value="Chưa thanh toán" <?php if($item['TrangThaiThanhToan'] == 'Chưa thanh toán') echo 'selected'; ?>>Chưa thanh toán</option>
                <option value="Thanh toán không thành công" <?php if($item['TrangThaiThanhToan'] == 'Thanh toán không thành công') echo 'selected'; ?>>Thanh toán không thành công</option>
            </select>
        </div>
        <div class="form-group">
            <label for="soTien">Số Tiền Thanh Toán:</label>
            <input type="number" step="0.01" class="form-control" id="soTien" name="soTien" value="<?php echo $item['SoTienThanhToan']; ?>" required>
        </div>
        <div class="form-group">
            <label for="thoiGian">Thời Gian Thanh Toán:</label>
            <input type="datetime-local" class="form-control" id="thoiGian" name="thoiGian" value="<?php echo date('Y-m-d\TH:i', strtotime($item['ThoiGianThanhToan'])); ?>" required>
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
        <a href="admin_dashboard_thanh_toan.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
