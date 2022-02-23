import {IProduct} from "./product";

export interface IShipment {
  id: number,
  shipment_id: string,
  product_shipment:IProduct,
  amount: string,
  dateAdd: string,
  dateProduce: string,
  dateExpiration: string
}
