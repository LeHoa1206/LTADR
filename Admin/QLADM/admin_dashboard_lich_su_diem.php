<?php
include 'LichSuDiem.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$lichSuDiem = new LichSuDiem($conn);

// Lấy danh sách lịch sử điểm
$lichSuList = $lichSuDiem->layTatCa();
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Trị Lịch Sử Điểm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Quản Trị Lịch Sử Điểm</h2>
    <a href="them_lich_su_diem.php" class="btn btn-primary mb-3">Thêm Lịch Sử Điểm</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Người Dùng ID</th>
                <th>Điểm Tháng</th>
                <th>Ngày Tích Lũy</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($lichSuList as $lichSu): ?>
                <tr>
                    <td><?php echo $lichSu['LichSuDiemID']; ?></td>
                    <td><?php echo $lichSu['NguoiDungID']; ?></td>
                    <td><?php echo $lichSu['DiemThang']; ?></td>
                    <td><?php echo $lichSu['NgayTichLuy']; ?></td>
                    <td>
                        <a href="sua_lich_su_diem.php?id=<?php echo $lichSu['LichSuDiemID']; ?>" class="btn btn-warning">Sửa</a>
                        <a href="xoa_lich_su_diem.php?id=<?php echo $lichSu['LichSuDiemID']; ?>" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa không?');">Xóa</a>
                    </td>
                </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</div>
</body>
</html>
