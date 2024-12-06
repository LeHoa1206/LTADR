<?php
include 'DanhGia.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$danhGia = new DanhGia($conn);
$dsDanhGia = $danhGia->layTatCa();
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Đánh Giá</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Quản Lý Đánh Giá</h2>
    <a href="them_danh_gia.php" class="btn btn-success mb-3">Thêm Đánh Giá</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Người Dùng ID</th>
                <th>Sản Phẩm ID</th>
                <th>Nội Dung</th>
                <th>Điểm</th>
                <th>Ngày Đánh Giá</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($dsDanhGia as $item): ?>
                <tr>
                    <td><?php echo $item['DanhGiaID']; ?></td>
                    <td><?php echo $item['NguoiDungID']; ?></td>
                    <td><?php echo $item['SanPhamID']; ?></td>
                    <td><?php echo $item['NoiDung']; ?></td>
                    <td><?php echo $item['Diem']; ?></td>
                    <td><?php echo $item['NgayDanhGia']; ?></td>
                    <td>
                        <a href="sua_danh_gia.php?id=<?php echo $item['DanhGiaID']; ?>" class="btn btn-warning">Sửa</a>
                        <a href="xoa_danh_gia.php?id=<?php echo $item['DanhGiaID']; ?>" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')">Xóa</a>
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
