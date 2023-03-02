package com.example.web_api_test.services.Impl;

import com.example.web_api_test.DTO.ProductDetailsDTO;
import com.example.web_api_test.models.ProductDetails;
import com.example.web_api_test.repositories.ProductDetailPropertyDetailsRepo;
import com.example.web_api_test.repositories.ProductDetailRepo;
import com.example.web_api_test.services.IProductDetailPropertyDetailService;
import com.phieuthu_lts.comon.Enum.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailPropertyDetailService implements IProductDetailPropertyDetailService {
    @Autowired
    private ProductDetailPropertyDetailsRepo productDetailPropertyDetailsRepo;
    @Autowired
    private ProductDetailService productDetailService;

    @Autowired
    private ProductDetailRepo productDetailRepo;

    @Override
    public Response<ProductDetailsDTO> addToCart(int productID, int propertyId_1, int propertyId_2, int propertyId_3, int quantityProduct) {
        Response<ProductDetailsDTO> res = new Response<>();
        int productDetailId = getProductDetailID(productID, propertyId_1, propertyId_2, propertyId_3);
        if(productDetailId == -1) {
            res.thatBai(null, "Không tìm thấy sản phẩm");
            return res;
        }
        Optional<ProductDetails> productDetails = productDetailRepo.findById(productDetailId);
        ProductDetails productDetail = productDetails.get();
        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
        BeanUtils.copyProperties(productDetail, productDetailsDTO);
        if(productDetails.isEmpty()) {
            res.thatBai(null, "Không tìm thấy sản phẩm ");
            return res;
        }
        if(quantityProduct <= 0) {
            res.thatBai(productDetailsDTO, "Số lượng không hợp lệ");
            return res;
        }
        res = productDetailService.subtractQuantityProduct(productDetail,quantityProduct);
        if(res.getMes() == "") {
            res.thanhcong(productDetailsDTO, "Bạn đã mua " + productDetailsDTO.getProductDetailName() +
                    " với số lượng là: " + quantityProduct);
        }
        return res;
    }

    @Override
    public Response<ProductDetailsDTO> addToCart(int productID, int propertyId_1, int propertyId_2, int quantityProduct) {
        Response<ProductDetailsDTO> res = new Response<>();
        int productDetailId = getProductDetailID(productID, propertyId_1, propertyId_2);
        if(productDetailId == -1) {
            res.thatBai(null, "Không tìm thấy sản phẩm");
            return res;
        }
        Optional<ProductDetails> productDetails = productDetailRepo.findById(productDetailId);
        ProductDetails productDetail = productDetails.get();
        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
        BeanUtils.copyProperties(productDetail, productDetailsDTO);
        if(productDetails.isEmpty()) {
            res.thatBai(null, "Không tìm thấy sản phẩm ");
            return res;
        }
        if(quantityProduct <= 0) {
            res.thatBai(productDetailsDTO, "Số lượng không hợp lệ");
            return res;
        }
        res = productDetailService.subtractQuantityProduct(productDetail,quantityProduct);
        if(res.getMes() == "") {
            res.thanhcong(productDetailsDTO, "Bạn đã mua " + productDetailsDTO.getProductDetailName() +
                    " với số lượng là: " + quantityProduct);
        }
        return res;
    }

    @Override
    public Response<ProductDetailsDTO> updateProduct(int productID, int propertyId_1, int propertyId_2, int propertyId_3, int quantityProduct) {
        Response<ProductDetailsDTO> res = new Response<>();
        int productDetailId = getProductDetailID(productID, propertyId_1, propertyId_2, propertyId_3);
        if(productDetailId == -1) {
            res.thatBai(null, "Không tìm thấy sản phẩm");
            return res;
        }
        Optional<ProductDetails> productDetails = productDetailRepo.findById(productDetailId);
        ProductDetails productDetail = productDetails.get();
        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
        BeanUtils.copyProperties(productDetail, productDetailsDTO);
        if(productDetails.isEmpty()) {
            res.thatBai(null, "Không tìm thấy sản phẩm ");
            return res;
        }
        productDetailService.updateQuantityProduct(productDetail,quantityProduct);
        res.thanhcong(productDetailsDTO, "Update " + productDetailsDTO.getProductDetailName() +
                " với số lượng là: " + quantityProduct);
        return res;
    }

    @Override
    public Response<ProductDetailsDTO> updateProduct(int productID, int propertyId_1, int propertyId_2, int quantityProduct) {
        Response<ProductDetailsDTO> res = new Response<>();
        int productDetailId = getProductDetailID(productID, propertyId_1, propertyId_2);
        if(productDetailId == -1) {
            res.thatBai(null, "Không tìm thấy sản phẩm");
            return res;
        }
        Optional<ProductDetails> productDetails = productDetailRepo.findById(productDetailId);
        ProductDetails productDetail = productDetails.get();
        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
        BeanUtils.copyProperties(productDetail, productDetailsDTO);
        if(productDetails.isEmpty()) {
            res.thatBai(null, "Không tìm thấy sản phẩm ");
            return res;
        }
        productDetailService.updateQuantityProduct(productDetail,quantityProduct);
        res.thanhcong(productDetailsDTO, "Update " + productDetailsDTO.getProductDetailName() +
                " với số lượng là: " + quantityProduct);
        return res;
    }

    public Integer getProductDetailID(int productID, int propertyId_1, int propertyId_2, int propertyId_3 ){
        List<Integer> list1 = productDetailPropertyDetailsRepo.ProductDetailId_List(productID, propertyId_1);
        List<Integer> list2 = productDetailPropertyDetailsRepo.ProductDetailId_List(productID, propertyId_2);
        List<Integer> list_stamp1 = new ArrayList<>();
        List<Integer> list3 = productDetailPropertyDetailsRepo.ProductDetailId_List(productID, propertyId_3);
        List<Integer> list_stamp2 = new ArrayList<>();
            list1.forEach(x-> {
                list2.forEach(y -> {
                    if(x == y) {
                        list_stamp1.add(x);
                    }
                });
            });
            list_stamp1.forEach(x -> {
                list3.forEach(y -> {
                    if(x == y ){
                        list_stamp2.add(x);
                    }
                });
            });
            if(list_stamp2.size() == 0){
                return -1;
            }
            return list_stamp2.get(0);
     }
    public Integer getProductDetailID(int productID, int propertyId_1, int propertyId_2 ){
        List<Integer> list1 = productDetailPropertyDetailsRepo.ProductDetailId_List(productID, propertyId_1);
        List<Integer> list2 = productDetailPropertyDetailsRepo.ProductDetailId_List(productID, propertyId_2);
        List<Integer> list_stamp1 = new ArrayList<>();
        list1.forEach(x-> {
            list2.forEach(y -> {
                if(x == y) {
                    list_stamp1.add(x);
                }
            });
        });
        if(list_stamp1.size() == 0) {
            return -1;
        }
        return list_stamp1.get(0);
    }
}
