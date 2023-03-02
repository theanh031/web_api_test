package com.example.web_api_test.services.Impl;

import com.example.web_api_test.DTO.ProductDetailsDTO;
import com.example.web_api_test.models.ProductDetails;
import com.example.web_api_test.repositories.ProductDetailRepo;
import com.example.web_api_test.services.IProductDetailService;
import com.phieuthu_lts.comon.Enum.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailService implements IProductDetailService {
    @Autowired
    private ProductDetailRepo productDetailRepo;

    @Override
    public Response<List<ProductDetailsDTO>> selectAllTable() {
        Response<List<ProductDetailsDTO>> res = new Response();
        List<ProductDetails> productDetails =productDetailRepo.selectAll();
        List<ProductDetailsDTO> productDetailsDTOs = new ArrayList<>();
        productDetails.forEach(x -> {
            ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
            BeanUtils.copyProperties(x, productDetailsDTO);
            productDetailsDTOs.add(productDetailsDTO);
        });
        res.thanhcong(productDetailsDTOs, "");
        return res;

    }

    public Response<ProductDetailsDTO> subtractQuantityProduct(ProductDetails productDetails, int quatityProduct){
        Response<ProductDetailsDTO> res = new Response<>();
        res.setMes("");
        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
        BeanUtils.copyProperties(productDetails, productDetailsDTO);
        if(productDetails.getParentId() != null){
            Optional<ProductDetails> productDetailParent1 = productDetailRepo.findById(productDetails.getParentId());
            if(productDetailParent1.get().getParentId() != null){
                Optional<ProductDetails> productDetailParent2 = productDetailRepo.findById(productDetailParent1.get().getParentId());

                if(productDetails.getQuantity() == 0
                        || productDetailParent1.get().getQuantity() == 0
                        || productDetailParent2.get().getQuantity() == 0) {
                    res.thatBai(productDetailsDTO, "Hết Hàng rồi");
                    return res;
                }
                if(productDetails.getQuantity() < quatityProduct
                        || productDetailParent1.get().getQuantity() < quatityProduct
                        || productDetailParent2.get().getQuantity() < quatityProduct){
                    res.thatBai(productDetailsDTO, "Số lượng hàng không đủ");
                    return res;
                }
                productDetails.setQuantity(productDetails.getQuantity() - quatityProduct);
                productDetailRepo.save(productDetails);
                productDetailParent1.get().setQuantity(productDetailParent1.get().getQuantity() - quatityProduct);
                productDetailRepo.save(productDetailParent1.get());
                productDetailParent2.get().setQuantity(productDetailParent2.get().getQuantity() - quatityProduct);
                productDetailRepo.save(productDetailParent2.get());
                return res;
            }
            else {
                if (productDetails.getQuantity() == 0
                        || productDetailParent1.get().getQuantity() == 0) {
                    res.thatBai(productDetailsDTO, "Hết Hàng rồi");
                    return res;
                }
                if (productDetails.getQuantity() < quatityProduct
                        || productDetailParent1.get().getQuantity() < quatityProduct) {
                    res.thatBai(productDetailsDTO, "Số lượng hàng không đủ");
                    return res;
                }
                productDetails.setQuantity(productDetails.getQuantity() - quatityProduct);
                productDetailRepo.save(productDetails);
                productDetailParent1.get().setQuantity(productDetailParent1.get().getQuantity() - quatityProduct);
                productDetailRepo.save(productDetailParent1.get());
                return res;
            }

        }
        return res;
    }
    public void updateQuantityProduct(ProductDetails productDetails, int quatityProduct){
        productDetails.setQuantity(productDetails.getQuantity() + quatityProduct);
        productDetailRepo.save(productDetails);
        if(productDetails.getParentId() != null){
            Optional<ProductDetails> productDetailParent1 = productDetailRepo.findById(productDetails.getParentId());
            productDetailParent1.get().setQuantity(productDetails.getQuantity() + quatityProduct);
            productDetailRepo.save(productDetailParent1.get());
            if(productDetailParent1.get().getParentId() != null){
                Optional<ProductDetails> productDetailParent2 = productDetailRepo.
                        findById(productDetailParent1.get().getParentId());
                productDetailParent2.get().setQuantity(productDetailParent2.get().getQuantity() + quatityProduct);
                productDetailRepo.save(productDetailParent2.get());
            }
        }
    }

}
