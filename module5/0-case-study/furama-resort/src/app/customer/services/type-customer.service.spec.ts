import { TestBed } from '@angular/core/testing';

import { TypeCustomerService } from './type-customer.service';

describe('TypeCustomerService', () => {
  let service: TypeCustomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypeCustomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
