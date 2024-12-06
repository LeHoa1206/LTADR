<?php
include 'DonHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$donHang = new DonHang($conn);
$orders = $donHang->layTatCa();
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Đơn Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Quản Lý Đơn Hàng</h2>
    <a href="them_donhang.php" class="btn btn-primary mb-3">Thêm Đơn Hàng</a>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Người Dùng ID</th>
                <th>Ngày Đặt</th>
                <th>Trạng Thái</th>
                <th>Thời Gian Cập Nhật</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($orders as $order): ?>
            <tr>
                <td><?php echo $order['DonHangID']; ?></td>
                <td><?php echo $order['NguoiDungID']; ?></td>
                <td><?php echo $order['NgayDat']; ?></td>
                <td><?php echo $order['TrangThai']; ?></td>
                <td><?php echo $order['ThoiGianCapNhat']; ?></td>
                <td>
                    <a href="sua_donhang.php?id=<?php echo $order['DonHangID']; ?>" class="btn btn-warning">Sửa</a>
                    <a href="xoa_donhang.php?id=<?php echo $order['DonHangID']; ?>" class="btn btn-danger">Xóa</a>
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
