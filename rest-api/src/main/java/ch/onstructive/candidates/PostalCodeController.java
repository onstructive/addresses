/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

/**
 * REST controller for postal codes.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
@Controller("/api/v1/postalcodes")
public class PostalCodeController {

  private final AddressService addressService;
  private final PostalCodeControllerMapper postalCodeControllerMapper;

  public PostalCodeController(
      AddressService addressService, PostalCodeControllerMapper postalCodeControllerMapper) {
    this.addressService = addressService;
    this.postalCodeControllerMapper = postalCodeControllerMapper;
  }

  @Get
  public List<PostalCodeGetModel> findAllPostalCodes() {
    return addressService.findAllPostalCodes().stream()
        .map(postalCodeControllerMapper::toPostalCodeGetModel)
        .collect(Collectors.toList());
  }

  @Get("/{id}")
  public PostalCodeGetModel findPostalCode(Long id) {
    return addressService
        .find(id)
        .map(postalCodeControllerMapper::toPostalCodeGetModel)
        .orElseThrow(() -> new NotFoundException(id, "postalCode"));
  }

  @Post
  public HttpStatus create(@Valid @Body PostalCodePostModel model) {
    addressService.createPostalCode(postalCodeControllerMapper.toPostalCodeDTO(model));
    return HttpStatus.CREATED;
  }

  @Put
  public HttpStatus update(@Valid @Body PostalCodePutModel model) {
    return HttpStatus.OK;
  }

  static class PostalCodeGetModel {

    private Long id;
    private Short postalCode;
    private String name;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Short getPostalCode() {
      return postalCode;
    }

    public void setPostalCode(Short postalCode) {
      this.postalCode = postalCode;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      PostalCodeGetModel that = (PostalCodeGetModel) o;
      return Objects.equals(id, that.id)
          && Objects.equals(postalCode, that.postalCode)
          && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, postalCode, name);
    }
  }

  @Introspected
  static class PostalCodePostModel {

    @Min(1000)
    @Max(9999)
    private Short postalCode;

    @NotBlank private String name;

    public Short getPostalCode() {
      return postalCode;
    }

    public void setPostalCode(Short postalCode) {
      this.postalCode = postalCode;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  @Introspected
  static class PostalCodePutModel {

    @NotNull private Long id;

    @Min(1000)
    @Max(9999)
    private Short postalCode;

    @NotBlank private String name;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Short getPostalCode() {
      return postalCode;
    }

    public void setPostalCode(Short postalCode) {
      this.postalCode = postalCode;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
