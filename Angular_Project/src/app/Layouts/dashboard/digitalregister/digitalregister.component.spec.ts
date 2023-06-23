import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DigitalregisterComponent } from './digitalregister.component';

describe('DigitalregisterComponent', () => {
  let component: DigitalregisterComponent;
  let fixture: ComponentFixture<DigitalregisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DigitalregisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DigitalregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
