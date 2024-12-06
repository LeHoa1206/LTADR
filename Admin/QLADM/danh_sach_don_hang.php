<?php
include 'config.php';
include 'DonHang.php';

$donHang = new DonHang($conn);
$donHangs = $donHang->getAll();
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Đơn Hàng</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Danh Sách Đơn Hàng</h2>
    <a href="them_don_hang.php" class="btn btn-success mb-3">Thêm Đơn Hàng</a>
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Ngày Đặt</th>
                <th>Tổng Tiền</th>
                <th>Trạng Thái</th>
                <th>Người Dùng</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
        <?php foreach ($donHangs as $dh) { ?>
            <tr>
                <td><?php echo $dh['DonHangID']; ?></td>
                <td><?php echo $dh['NgayDat']; ?></td>
                <td><?php echo $dh['TongTien']; ?></td>
                <td><?php echo $dh['TrangThai']; ?></td>
                <td><?php echo $dh['NguoiDungID']; ?></td>
                <td>
                    <a href="sua_don_hang.php?id=<?php echo $dh['DonHangID']; ?>" class="btn btn-warning btn-sm">Sửa</a>
                    <a href="xoa_don_hang.php?id=<?php echo $dh['DonHangID']; ?>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </td>
            </tr>
        <?php } ?>
        </tbody>
    </table>
</div>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
