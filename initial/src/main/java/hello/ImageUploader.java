package hello;

import java.io.File;
import java.net.URLEncoder;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.auth.AWSStaticCredentialsProvider;

/**
 * ImageUploader
 */
public class ImageUploader {

    final String bucketName = "screenshot-java-capture";
    private AmazonS3 s3Client;
    
    public ImageUploader() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(
            System.getenv("AWS_ACCESS_KEY"),
            System.getenv("AWS_SECRET_ACCESS_KEY")
        );

        // Initialize S3 client with credentials and region
        this.s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(System.getenv("AWS_REGION"))
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .build();
    }

    public void uploadImage(String url, File f) {
        // The name of the image on S3
        String fileName = URLEncoder.encode(url) + ".jpg";
        PutObjectRequest request = new PutObjectRequest(bucketName, fileName, f);
        ObjectMetadata metadata = new ObjectMetadata();
        // Set the image type
        metadata.setContentType("image/jpeg");
        request.setMetadata(metadata);
        // Upload the image to S3
        s3Client.putObject(request);
    }
    
}