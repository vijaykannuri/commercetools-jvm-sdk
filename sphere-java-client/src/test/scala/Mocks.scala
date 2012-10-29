package de.commercetools.sphere.client

import de.commercetools.internal._
import de.commercetools.sphere.client.shop._
import request.RequestFactory

object Mocks {
  // endpoints are relative to an empty backend url -> "/products", "/carts/:id" etc.
  private val endpoints = new ProjectEndpoints("")

  private def mockProducts(reqFactory: RequestFactory): Products = new ProductsImpl(reqFactory, endpoints)

  private def mockCategories(reqFactory: RequestFactory): Categories = new CategoriesImpl(reqFactory, endpoints)

  private def mockCarts(reqFactory: RequestFactory): Carts = new CartsImpl(reqFactory, endpoints)

  private def mockOrders(reqFactory: RequestFactory): Orders = new OrdersImpl(reqFactory, endpoints)

  private def mockCustomers(reqFactory: RequestFactory): Customers = new CustomersImpl(reqFactory, endpoints)

  /** Use this if you want to test the whole Shop clients. */
  def mockShopClient(fakeBackendResponse: String, fakeStatus: Int = 200) = {
    val reqFactory = new MockRequestFactory(fakeBackendResponse, fakeStatus)
    new ShopClient(
      new ShopClientConfig.Builder("projectKey", "clientId", "clientSecret").build,
      mockProducts(reqFactory),
      CategoryTreeImpl.createAndBeginBuildInBackground(mockCategories(reqFactory)),
      mockCarts(reqFactory),
      mockOrders(reqFactory),
      mockCustomers(reqFactory))
  }
}
