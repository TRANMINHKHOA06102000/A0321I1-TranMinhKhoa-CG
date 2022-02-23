import { ICustomerType } from './customerType';

export interface ICustomer {
  id: number;
  cus_id: string;
  cus_type: ICustomerType;
  name: string;
  birthday: string;
  gender: string;
  id_card: string;
  phone: string;
  email: string;
  address: string;
}
