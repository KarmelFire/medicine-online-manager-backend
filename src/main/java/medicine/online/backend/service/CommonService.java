package medicine.online.backend.service;

import medicine.online.backend.model.vo.FileUrlVO;
import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
    /**
     * 图片上传
     *
     * @param uploadFile 上传文件
     * @return 上传文件返回视图
     */
    FileUrlVO upload(MultipartFile uploadFile);

}