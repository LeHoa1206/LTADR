<?php
include 'ThanhToan.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$thanhToan = new ThanhToan($conn);
$paymentItems = $thanhToan->layTatCa();
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Thanh Toán</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Quản Lý Thanh Toán</h2>
    <a href="them_thanh_toan.php" class="btn btn-primary mb-3">Thêm Thanh Toán</a>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>ID Đơn Hàng</th>
                <th>Phương Thức Thanh Toán</th>
                <th>Trạng Thái Thanh Toán</th>
                <th>Số Tiền Thanh Toán</th>
                <th>Thời Gian Thanh Toán</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($paymentItems as $item): ?>
            <tr>
                <td><?php echo $item['ThanhToanID']; ?></td>
                <td><?php echo $item['DonHangID']; ?></td>
                <td><?php echo $item['PhuongThucThanhToan']; ?></td>
                <td><?php echo $item['TrangThaiThanhToan']; ?></td>
                <td><?php echo number_format($item['SoTienThanhToan'], 2); ?> VNĐ</td>
                <td><?php echo $item['ThoiGianThanhToan']; ?></td>
                <td>
                    <a href="sua_thanh_toan.php?id=<?php echo $item['ThanhToanID']; ?>" class="btn btn-warning">Sửa</a>
                    <a href="xoa_thanh_toan.php?id=<?php echo $item['ThanhToanID']; ?>" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
