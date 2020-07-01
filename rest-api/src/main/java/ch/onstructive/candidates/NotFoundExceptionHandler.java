/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import javax.inject.Singleton;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

/**
 * Converts {@link NotFoundException} into a HTTP status 404.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
@Produces
@Singleton
@Requires(classes = {NotFoundException.class, ExceptionHandler.class})
public class NotFoundExceptionHandler implements ExceptionHandler<NotFoundException, HttpResponse> {

  @Override
  public HttpResponse handle(HttpRequest request, NotFoundException exception) {
    return HttpResponse.notFound();
  }
}
