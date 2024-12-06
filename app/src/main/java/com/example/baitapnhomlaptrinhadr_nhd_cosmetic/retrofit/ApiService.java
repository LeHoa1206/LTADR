package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.AddToCartRequest;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.ApiReponseDH;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.ApiResponse;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.CartItem;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHang;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.GioHang;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.NguoiDung;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.SanPham;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone.BinhLuanRespone;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone.DanhGiaResponse;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHang;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone.ResponseCart;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    // Lấy tất cả sản phẩm
    @GET("sanpham.php")  // Đảm bảo đây là endpoint API thực tế của bạn
    Observable<ApiResponse> getSanPhamList();  // Observable trả về ResponseData chứa danh sách sản phẩm
    @GET("sanphamnoibat.php")
    Observable<ApiResponse> getSanPhamListNoiBat();
    @GET("sanphamdexuat.php")
    Observable<ApiResponse> getSanPhamListDexuat();
    // Lấy danh sách đơn hàng admin
    @GET("Danhsachdonhang.php")  // Đảm bảo đây là endpoint API thực tế của bạn
    Observable<ApiReponseDH> getdanhsachdonhangadmin(); // Sử dụng ApiReponseDH



    @GET("search.php")  // Thay URL này bằng URL của API
    Observable<ApiResponse> searchSanPham(@Query("query") String query);

    @GET("san_pham_ban_chay.php")
    Call<List<SanPham>> getAllSPBanChay();

    @GET("san_pham_noi_bac.php")
    Call<List<SanPham>> getAllSPNoiBac();

    @GET("san_pham_de_xuat.php")
    Call<List<SanPham>> getAllSPDeXuat();
    @GET("san_pham_de_xuat-nam.php")
    Call<List<SanPham>> getAllSPDeXuatNam();

    @GET("san_pham_de_xuat_nu.php")
    Call<List<SanPham>> getAllSPDeXuatNu();

    @GET("san_pham_de_xuat_phukien.php")
    Call<List<SanPham>> getAllSPDeXuatPhuKien();
    @GET("san_pham_de_xuat_lamdep.php")
    Call<List<SanPham>> getAllSPDeXuatLamDep();
    @GET("get_san_pham_by_id.php")
    Call<SanPham> getSanPhamById(@Query("SanPhamID") int sanPhamID);

    @GET("get_diem_danh_gia_by_id.php")
    Call<DanhGiaResponse> getDanhGiaById(@Query("SanPhamID") int sanPhamID);

    @GET("get_all_danh_gia.php")
    Call<List<BinhLuanRespone>> getAllBinhLuanById(@Query("SanPhamID") int sanPhamID);
    @GET("login.php")
    Call<NguoiDung> loginUser(@Query("username") String username, @Query("password") String password);

    @GET("get_orders.php")  // Đường dẫn đến file PHP của bạn
    Call<List<DonHang>> getOrders(@Query("NguoiDungID") int nguoiDungID);
    @POST("add_to_cart.php")
    Call<Void> addToCart(@Body GioHang gioHang);

    @POST("donhang.php")  // Đảm bảo đây là endpoint API thực tế của bạn
    Observable<ApiReponseDH> addDonHang(@Body DonHangAdmin donHangAdmin);

    // Cập nhật đơn hàng
    @POST("updateDonHang.php")  // Endpoint cho cập nhật đơn hàng
    Call<ApiReponseDH> updateDonHang(@Body DonHangAdmin donHangAdmin);

    // Xóa đơn hàng
    @POST("deleteDonHang.php")  // Endpoint cho xóa đơn hàng
    Observable<ApiReponseDH> deleteDonHang(@Query("DonHangID") int DonHangId);

    //thêm sp vào giỏ
    @POST("add_to_cart.php")
    Call<Void> addToCart(@Body AddToCartRequest request);

    //load giỏ hang
    @GET("get_cart.php")
    Call<ResponseCart> getCartItems(@Query("NguoiDungID") int nguoiDungID);

    /// Phương thức xóa các sản phẩm đã chọn từ giỏ hàng
    @POST("delete_cart_item.php")
    Call<Void> deleteSelectedItems(@Query("NguoiDungID") int nguoiDungID, @Body String items);
}
